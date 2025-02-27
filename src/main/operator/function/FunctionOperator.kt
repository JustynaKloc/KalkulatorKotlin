package main.operator.function

import main.operator.function.trigonometry.CosFunction
import main.exception.InvalidSyntaxException
import main.Operator
import main.operator.function.trigonometry.*

abstract class FunctionOperator internal constructor(symbol: String, numOfParams: Int) : Operator(numOfParams, symbol) {
    
    companion object {
        
        val SINE = SinFunction()
        val COSINE = CosFunction()
        val TANGENT = TanFunction()
        val SQRT = SqrtFunction()
        val LOG = LogFunction()

        val OPERATORS = arrayOf(
                SINE, COSINE, TANGENT, SQRT, LOG
        )

        fun isOperator(str: String): Boolean = OPERATORS.any{ it -> it.isStringEquivalent(str)}
        
        fun parse(string: String): FunctionOperator {
            try {
                return OPERATORS.first { op -> op.isStringEquivalent(string) }
            } catch (e: NoSuchElementException){
                throw InvalidSyntaxException(string + " is not a function.")
            } 
        }

    }

    override fun getPrecedence(): Int = Int.MAX_VALUE
}