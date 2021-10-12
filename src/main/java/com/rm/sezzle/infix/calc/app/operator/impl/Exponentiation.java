package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
/**
 * Exponentiation class implements the power operation.<br/>
 * It implements the <i>Operator</i> Abstract class with the concrete implementation pertaining to a specific operation.<br/>
 * It also sets specific priority and symbol corresponding to the given Operation.
 *
 * @author Rajagopal M
 */
public class Exponentiation extends Operator {
    /**
     *  Constructor to Initialise the Operation with specific priority and Symbol.
     *
     */
    public Exponentiation() {
        super(CalculatorAppConstants.POWER_OPERATOR, CalculatorAppConstants.POWER_PRIORITY_THREE);
    }

    /**
     * Execute methods applies the Exponentiation operation on the operands passed.
     *
     * @param first  Operand involved in the Operation
     * @param second Operand involved in the Operation
     * @return Operand resulting in the power of the given 2 Operands
     */
    @Override
    public Operand execute(Operand first, Operand second) {
        return new Operand(Math.pow(first.getValue(), second.getValue()));
    }
}
