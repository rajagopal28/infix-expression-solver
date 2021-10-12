package com.rm.sezzle.infix.calc.app.exception;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;

/**
 * Exception thrown while trying to work with some operator that is not implemented.
 *
 *  @author Rajagopal M
 *
 */
public class OperationNotImplementedException extends  RuntimeException {
    public OperationNotImplementedException(String token) {
        super(CalculatorAppConstants.ERROR_OPERATOR_NOT_FOUND.apply(token));
    }
}
