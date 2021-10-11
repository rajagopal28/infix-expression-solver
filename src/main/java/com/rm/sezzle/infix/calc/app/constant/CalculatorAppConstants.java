package com.rm.sezzle.infix.calc.app.constant;

import java.util.Map;
import java.util.function.Function;

public interface CalculatorAppConstants {
    String ADD_OPERATOR = "+";
    String SUB_OPERATOR = "-";
    String MULTIPLY_OPERATOR = "*";
    String POWER_OPERATOR = "^";
    String DIVIDE_OPERATOR = "/";

    int OPEN_BRACKETS_PRIORITY_ZERO = 0;
    int ADD_SUB_PRIORITY_ONE = 1;
    int MULTI_DIVIDE_PRIORITY_TWO = 2;
    int POWER_PRIORITY_THREE = 3;
    int CLOSE_BRACKETS_PRIORITY_FOUR = 4;

    String DECIMAL_REGEX = "^\\d+\\.?\\d*$";
    String EXPRESSION_TOKENIZATION_DELIMITERS = "+-*^/(){}[] ";

    String ERROR_INVALID_NUMBER = "Not a valid number!";
    String ERROR_DIVIDE_BY_ZERO = "Cannot Divide by zero!!";
    String ERROR_BRACKETS_NOT_PROPERLY_FORMED = "Braces not formed correctly!!\"";
    String ERROR_INVALID_EXPRESSION_FORMATION = "Infix Expression not well formed!!";

    Map<String, String> BRACKET_PAIRS = Map.of(")", "(", "}", "{", "]", "[");

    Function<String, String> ERROR_OPERATOR_NOT_FOUND = (s) -> "Operator Symbol("+s+") not found in Factory!";
}
