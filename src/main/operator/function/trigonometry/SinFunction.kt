package main.operator.function.trigonometry

import main.Operand
import main.bd
import main.operator.function.FunctionOperator

class SinFunction internal constructor() : FunctionOperator("sin",1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand((Math.sin(operands[0].value.toDouble())).bd)
    }

    override fun toString(): String = "Sine"
}