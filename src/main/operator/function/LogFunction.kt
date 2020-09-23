package main.operator.function

import main.Operand
import main.bd
import kotlin.math.ln

class LogFunction internal constructor() : FunctionOperator("log",1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand((ln(operands[0].value.toDouble())).bd)
    }

    override fun toString(): String = "Log"

}