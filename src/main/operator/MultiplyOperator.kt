package main.operator

import main.Operand
import main.Operator

class MultiplyOperator internal constructor() : Operator(2, "x") {

    override fun getPrecedence() = 1

    override fun operate(vararg operands: Operand): Operand {
        return Operand(operands[0].value.multiply(operands[1].value, Operator.CONTEXT))
    }

    override fun toString() = "\u00D7"
}