import javafx.application.Application
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.input.KeyEvent
import javafx.scene.layout.VBox
import main.Postfix
import java.lang.Math
import tornadofx.*
import kotlin.math.*

class MyApp: App(MyView::class)

class MyView: View() {

    override val root: VBox by fxml()
    @FXML
    lateinit var display: Label
    @FXML
    lateinit var displayStack : Label

    init {
        title = "Kalkulator"

        root.lookupAll(".button").forEach { button ->
            button.setOnMouseClicked {
                op((button as Button).text)
            }
        }

        // Keyboard support
        root.addEventFilter(KeyEvent.KEY_TYPED) {
            op(it.character.toUpperCase().replace("\r", "="))
        }
    }

    var curried: Op = Op.add(0.0F)

    fun opAction(fn: Op) {
        curried = fn
        display.text = ""
    }

    val displayValue: Float
        get() = when (display.text) {
            "" -> 0.0F
            else -> display.text.toFloat()
        }


    private fun op(x: String): Unit {
        if (Regex("[0-9]").matches(x)) {
            display.text += x
            displayStack.text += x

        } else {
            when (x) {
                "+" -> {opAction(Op.add(displayValue)); displayStack.text += "+" }
                "-" -> {opAction(Op.sub(displayValue)); displayStack.text += "-" }
                "/" -> {opAction(Op.div(displayValue)); displayStack.text += "/" }
                "%" -> { opAction(Op.add(displayValue / 100)); display.text = curried.calc(displayValue).toString(); displayStack.text = display.text}
                "x" -> {opAction(Op.mult(displayValue)); displayStack.text += "x" }
                "C" -> {opAction(Op.add(0.0F)); displayStack.text = ""}
                "+/-" -> { opAction(Op.add(-1 * displayValue)); display.text = curried.calc(displayValue).toString(); displayStack.text = display.text }//; op("=") }
                "=" -> {
                    val myExpression = Postfix.from(displayStack.text)
                    val result = Postfix.evaluate(myExpression)
                    val value = result.value
                    display.text = value.toString()
                    displayStack.text = value.toString()
                }

                "x^y" -> opAction(Op.iksdoy(displayValue))
                "π" -> {opAction(Op.add(Math.PI.toFloat())); displayStack.text += "3.1415" }//; op("=")}
                "sin" -> {opAction(Op.add((sin((displayValue.toFloat())).toFloat()))); displayStack.text += "sin" }//; op("=")}
                "cos" -> {opAction(Op.add(cos(displayValue.toFloat()).toFloat())); displayStack.text += "cos" }//; op("=")}
                "x^2" -> {opAction(Op.add(displayValue * displayValue))}//; op("=")}
                "√x" -> {opAction(Op.add(sqrt(displayValue.toFloat()).toFloat())); displayStack.text += "√" }//; op("=")}
                "tan" -> {opAction(Op.add((tan((displayValue.toFloat())).toFloat()))); displayStack.text += "tan" }//; op("=")}
                "log" -> {opAction(Op.add((log10((displayValue.toFloat())).toFloat()))); displayStack.text += "log" }//; op("=")}
                "DEL" -> {display.text = ""; displayStack.text = ""}
                "(" -> {displayStack.text += "("}
                ")" -> {displayStack.text += ")"}
                "." -> {display.text += "."; displayStack.text += "."}

            }

        }

    }

}


sealed class Op(val x: Float) {
    abstract fun calc(y: Float): Float

    class add(x: Float) : Op(x) { override fun calc(y: Float) = x + y }
    class sub(x: Float) : Op(x) { override fun calc(y: Float) = x - y }
    class mult(x: Float) : Op(x) { override fun calc(y: Float) = x * y }
    class div(x: Float) : Op(x) { override fun calc(y: Float) = x / y }
    class iksdoy(x: Float) : Op(x) { override fun calc(y: Float) = ((x.toDouble()).pow((y.toDouble()))).toFloat() }
}


fun main(args: Array<String>) {
    importStylesheet("/style.css")
    Application.launch(MyApp::class.java, *args)
}
