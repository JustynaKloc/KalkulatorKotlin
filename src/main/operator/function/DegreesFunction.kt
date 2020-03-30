package main.operator.function

import main.Operand
import main.bd

class DegreesFunction internal constructor() : FunctionOperator("deg", 1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand((Math.toDegrees(operands[0].value.toDouble())).bd)
    }

    override fun toString(): String = "ToDegrees"
}