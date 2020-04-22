package main.operator.function

import main.operator.function.trigonometry.CosineFunction
import main.operator.function.trigonometry.InverseCosineFunction
import main.operator.function.trigonometry.InverseSineFunction
import main.operator.function.trigonometry.InverseTangentFunction
import main.exception.InvalidSyntaxException
import main.Operator
import main.operator.function.trigonometry.*

abstract class FunctionOperator internal constructor(symbol: String, numOfParams: Int) : Operator(numOfParams, symbol) {
    
    companion object {
        
        val SINE = SineFunction()
        val INVERSESINE = InverseSineFunction()
        val COSINE = CosineFunction()
        val INVERSECOSINE = InverseCosineFunction()
        val TANGENT = TangentFunction()
        val INVERSETAN = InverseTangentFunction()
        val TODEGREES = DegreesFunction()
        val TORADIANS = RadiansFunction()
        val SQRT = SquareRootFunction()
        val ABSOLUTE = AbsoluteFunction()
        
        val OPERATORS = arrayOf(
                SINE, COSINE, TANGENT, TODEGREES, TORADIANS, SQRT,
                INVERSESINE, INVERSECOSINE, INVERSETAN, ABSOLUTE
        )

        fun isOperator(str: String): Boolean = OPERATORS.any{ it -> it.isStringEquivalent(str)}
        
        fun parse(string: String): FunctionOperator {
            try {
                return OPERATORS.first { op -> op.isStringEquivalent(string) }
            } catch (e: NoSuchElementException){
                throw InvalidSyntaxException(string + " is not a function.")
            } 
        }

    }

    override fun getPrecedence(): Int = Int.MAX_VALUE
}