package main.operator

import main.Operand
import main.Operator

class ModulusOperator internal constructor() : Operator(2, "%") {

    override fun getPrecedence() = 0

    override fun operate(vararg operands: Operand): Operand {
        return Operand(operands[0].value.remainder(operands[1].value))
    }

    override fun toString() = "Modulus"
}