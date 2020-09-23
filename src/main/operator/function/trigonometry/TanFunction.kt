package main.operator.function.trigonometry

import main.Operand
import main.bd
import main.operator.function.FunctionOperator

class TanFunction internal constructor() : FunctionOperator("tan", 1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand((Math.tan(operands[0].value.toDouble())).bd)
    }

    override fun toString(): String = "Tangent"
}