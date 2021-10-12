package com.rm.sezzle.infix.calc.app.exception;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;

/**
 * Exception thrown while trying to solve expression with mismatch in brackets.
 *
 * @author Rajagopal M
 *
 */
public class MalformedBracketsException extends RuntimeException {
    public MalformedBracketsException() {
        super(CalculatorAppConstants.ERROR_BRACKETS_NOT_PROPERLY_FORMED);
    }
}
