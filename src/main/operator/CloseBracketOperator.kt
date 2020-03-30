package main.operator

import main.exception.NonOperationalOperatorException
import main.Operand
import main.Operator

class CloseBracketOperator internal constructor() : Operator(0, ")") {

    override fun getPrecedence() = -1

    override fun operate(vararg operands: Operand): Operand {
        throw NonOperationalOperatorException("Close bracket operator does not have an operation.")
    }

    override fun toString() =  "CloseBracket"
}