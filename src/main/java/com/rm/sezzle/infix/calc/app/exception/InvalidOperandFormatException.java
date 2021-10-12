package com.rm.sezzle.infix.calc.app.exception;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;

/**
 * Exception thrown while trying to work with invalid operand format.
 *
 * @author Rajagopal M
 *
 */
public class InvalidOperandFormatException extends RuntimeException {
    public InvalidOperandFormatException() {
        super(CalculatorAppConstants.ERROR_INVALID_NUMBER);
    }
}
