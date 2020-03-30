package main.operator

import main.exception.NonOperationalOperatorException
import main.Operand
import main.Operator

class OpenBracketOperator internal constructor() : Operator(0, "(") {
    override fun getPrecedence() = -1

    override fun operate(vararg operands: Operand): Operand {
        throw NonOperationalOperatorException("Open bracket operator does not have an operation.")
    }

    override fun toString() =  "OpenBracket"
}