package main.exception

class NonOperationalOperatorException(msg: String = "Operator does not have an operation."): Exception(msg)