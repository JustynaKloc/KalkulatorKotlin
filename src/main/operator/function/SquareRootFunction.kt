package main.operator.function

import main.Operand
import main.bd

class SquareRootFunction internal constructor() : FunctionOperator("sqrt", 1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand(Math.sqrt(operands[0].value.toDouble()).bd)
    }

    override fun toString(): String = "SquareRoot"
}