package main.operator.function

import main.Operand
import main.bd

class AbsoluteFunction internal constructor() : FunctionOperator("abs",1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand(Math.abs(operands[0].value.toDouble()).bd)
    }

    override fun toString(): String = "AbsoluteValue"
}