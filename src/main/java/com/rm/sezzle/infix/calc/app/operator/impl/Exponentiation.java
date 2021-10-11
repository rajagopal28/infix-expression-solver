package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;

public class Exponentiation extends Operator {
    public Exponentiation() {
        super(CalculatorAppConstants.POWER_OPERATOR, CalculatorAppConstants.POWER_PRIORITY_THREE);
    }
    @Override
    public Operand execute(Operand first, Operand second) {
        return new Operand(Math.pow(first.getValue(), second.getValue()));
    }
}
