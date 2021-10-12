package com.rm.sezzle.infix.calc.app.exception;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;

public class InvalidOperandFormatException extends RuntimeException {
    public InvalidOperandFormatException() {
        super(CalculatorAppConstants.ERROR_INVALID_NUMBER);
    }
}
