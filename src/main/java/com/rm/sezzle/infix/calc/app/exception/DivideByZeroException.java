package com.rm.sezzle.infix.calc.app.exception;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;

public class DivideByZeroException extends RuntimeException{
    public DivideByZeroException() {
        super(CalculatorAppConstants.ERROR_DIVIDE_BY_ZERO);
    }
}
