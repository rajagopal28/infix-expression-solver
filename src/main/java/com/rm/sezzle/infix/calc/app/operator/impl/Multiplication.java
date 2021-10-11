package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;

public class Multiplication extends Operator {
    public Multiplication() {
        super("*", 2);
    }
    @Override
    public Operand execute(Operand first, Operand second) {
        return new Operand(first.getValue() * second.getValue());
    }
}
