package com.rm.sezzle.infix.calc.app.constant;

public interface CalculatorAppConstants {
    String ADD_OPERATOR = "+";
    String SUB_OPERATOR = "-";
    String MULTIPLY_OPERATOR = "*";

    int ADD_SUB_PRIORITY_ONE = 1;
    int MULTI_DIVIDE_PRIORITY_TWO = 2;

    String DECIMAL_REGEX = "^\\d+\\.?\\d*$";


    String ERROR_INVALID_NUMBER = "Not a valid number!";
    String ERROR_DIVIDE_BY_ZERO = "Cannot Divide by zero!!";
}
