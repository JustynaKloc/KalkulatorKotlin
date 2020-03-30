package main.operator.function

import main.Operand
import main.bd

class RadiansFunction internal constructor() : FunctionOperator("rad",1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand((Math.toRadians(operands[0].value.toDouble())).bd)
    }

    override fun toString(): String = "ToRadians"
}