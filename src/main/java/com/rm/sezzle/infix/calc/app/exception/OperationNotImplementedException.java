package com.rm.sezzle.infix.calc.app.exception;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;

public class OperationNotImplementedException extends  RuntimeException {
    public OperationNotImplementedException(String token) {
        super(CalculatorAppConstants.ERROR_OPERATOR_NOT_FOUND.apply(token));
    }
}
