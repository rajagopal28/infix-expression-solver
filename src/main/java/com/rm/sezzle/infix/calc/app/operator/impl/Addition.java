package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;

/**
 * Addition class implements the sum operation.<br/>
 * It implements the <i>Operator</i> Abstract class with the concrete implementation pertaining to a specific operation.<br/>
 * It also sets specific priority and symbol corresponding to the given Operation.
 *
 * @author Rajagopal M
 */
public class Addition extends Operator {
    /**
     *  Constructor to Initialise the Operation with specific priority and Symbol.
     *
     */
    public Addition() {
        super(CalculatorAppConstants.ADD_OPERATOR, CalculatorAppConstants.ADD_SUB_PRIORITY_ONE);
    }

    /**
     * Execute methods applies the Sum operation on the operands passed.
     *
     * @param first  Operand involved in the Operation
     * @param second Operand involved in the Operation
     * @return Operand resulting in the sum of the given 2 Operands
     */
    @Override
    public Operand execute(Operand first, Operand second) {
        return new Operand(first.getValue() + second.getValue());
    }
}
