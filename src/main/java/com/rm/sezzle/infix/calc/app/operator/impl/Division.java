package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.exception.DivideByZeroException;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
/**
 * Division class implements the division operation.<br/>
 * It implements the <i>Operator</i> Abstract class with the concrete implementation pertaining to a specific operation.<br/>
 * It also sets specific priority and symbol corresponding to the given Operation.
 *
 * @author Rajagopal M
 */
public class Division extends Operator {
    /**
     *  Constructor to Initialise the Operation with specific priority and Symbol.
     *
     */
    public Division() {
        super(CalculatorAppConstants.DIVIDE_OPERATOR, CalculatorAppConstants.MULTI_DIVIDE_PRIORITY_TWO);
    }

    /**
     * Execute methods applies the Division operation on the operands passed.
     *
     * @param first  Operand involved in the Operation
     * @param second Operand involved in the Operation
     * @return Operand resulting in the quotient of the given 2 Operands
     */
    @Override
    public Operand execute(Operand first, Operand second) {
        if(second.getValue() != 0) {
            return new Operand(first.getValue() / second.getValue());
        } else {
            throw new DivideByZeroException();
        }
    }
}
