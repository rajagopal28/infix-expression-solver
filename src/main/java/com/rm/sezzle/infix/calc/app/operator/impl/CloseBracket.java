package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;

public class CloseBracket extends Operator {
    public CloseBracket(String symbol) {
        super(symbol, CalculatorAppConstants.CLOSE_BRACKETS_PRIORITY_FOUR);
    }

    @Override
    public Operand execute(Operand first, Operand second) {
        return null;
    }
}
