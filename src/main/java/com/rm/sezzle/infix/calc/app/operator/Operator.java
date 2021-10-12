package com.rm.sezzle.infix.calc.app.operator;

import com.rm.sezzle.infix.calc.app.operand.Operand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


/*
* Operator is an abstract class that lets the child/concrete class to define its own operation.<br/>
* However it enables usability of the existing properties <i>symbol</i> and <i>priority</i> <br/>
*
* @author Rajagopal M
* */
@AllArgsConstructor
@Getter
@ToString
public abstract class Operator {
    private String symbol;
    private int priority;

    /**
     * Execute method performs the Operation that corresponds to the given Operator.
     *
     * @param first Operand involved in the Operation
     * @param second  Operand involved in the Operation
     * @return Operand that comes as a result of the Operation performed
     */
    public abstract Operand execute(Operand first, Operand second);
}
