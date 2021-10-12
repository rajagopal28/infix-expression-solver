package com.rm.sezzle.infix.calc.app.exception;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;

/**
 * Exception thrown while trying to divide a number with zero(0) as denominator.
 *
 * @author Rajagopal M
 *
 */
public class DivideByZeroException extends RuntimeException{
    public DivideByZeroException() {
        super(CalculatorAppConstants.ERROR_DIVIDE_BY_ZERO);
    }
}
