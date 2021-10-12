package com.rm.sezzle.infix.calc.app.exception;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;

/**
 * Exception thrown while trying to solve an invalid expression.
 * @author Rajagopal M
 *
 */
public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException() {
        super(CalculatorAppConstants.ERROR_INVALID_EXPRESSION_FORMATION);
    }
}
