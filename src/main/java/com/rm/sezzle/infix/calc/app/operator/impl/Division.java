package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.exception.DivideByZeroException;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;

public class Division extends Operator {
    public Division() {
        super(CalculatorAppConstants.DIVIDE_OPERATOR, CalculatorAppConstants.MULTI_DIVIDE_PRIORITY_TWO);
    }
    @Override
    public Operand execute(Operand first, Operand second) {
        if(second.getValue() != 0) {
            return new Operand(first.getValue() / second.getValue());
        } else {
            throw new DivideByZeroException();
        }
    }
}
