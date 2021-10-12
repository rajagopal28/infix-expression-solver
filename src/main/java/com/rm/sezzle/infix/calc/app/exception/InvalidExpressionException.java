package com.rm.sezzle.infix.calc.app.exception;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;

public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException() {
        super(CalculatorAppConstants.ERROR_INVALID_EXPRESSION_FORMATION);
    }
}
