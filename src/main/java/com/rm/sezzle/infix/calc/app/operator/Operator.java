package com.rm.sezzle.infix.calc.app.operator;

import com.rm.sezzle.infix.calc.app.operand.Operand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Operator {
    private String symbol;
    private int priority;
    public abstract Operand execute(Operand first, Operand second);
}
