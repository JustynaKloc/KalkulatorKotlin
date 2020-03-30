package main.operator

import main.Operand
import main.Operator

class MinusOperator internal constructor() : Operator(2, "-") {
    override fun getPrecedence() = 0

    override fun operate(vararg operands: Operand): Operand {
        return Operand(operands[0].value.minus(operands[1].value))
    }

    override fun toString() = "Minus"
}