package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;

public class Addition extends Operator {
    public Addition() {
        super(CalculatorAppConstants.ADD_OPERATOR, CalculatorAppConstants.ADD_SUB_PRIORITY_ONE);
    }

    @Override
    public Operand execute(Operand first, Operand second) {
        return new Operand(first.getValue() + second.getValue());
    }
}
