package main.operator.function.trigonometry

import main.Operand
import main.bd
import main.operator.function.FunctionOperator

class CosFunction internal constructor() : FunctionOperator("cos",1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand((Math.cos(operands[0].value.toDouble())).bd)
    }

    override fun toString(): String = "Cosine"
}