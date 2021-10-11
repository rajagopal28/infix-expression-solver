package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;

public class OpenBracket extends Operator {
    public OpenBracket(String symbol) {
        super(symbol, CalculatorAppConstants.OPEN_BRACKETS_PRIORITY_ZERO);
    }

    @Override
    public Operand execute(Operand first, Operand second) {
        return null;
    }
}
