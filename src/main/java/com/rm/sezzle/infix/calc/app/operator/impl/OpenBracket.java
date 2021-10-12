package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
/**
 * OpenBracket class implements the opening of scope operation<br/>
 * It implements the <i>Operator</i> Abstract class with the concrete implementation pertaining to a specific operation.<br/>
 * It also sets specific priority and symbol corresponding to the given Operation.
 *
 * @author Rajagopal M
 */
public class OpenBracket extends Operator {
    /**
     * Constructor to Initialise the Operation with specific priority and Symbol.
     * @param symbol that corresponds to OpenBracket
     */
    public OpenBracket(String symbol) {
        super(symbol, CalculatorAppConstants.OPEN_BRACKETS_PRIORITY_ZERO);
    }

    /**
     * Execute methods does nothing as Brackets do not have any computation involved.
     *
     * @param first  Operand involved in the Operation
     * @param second Operand involved in the Operation
     * @return Null Operand as Brackets does not have any computation
     */
    @Override
    public Operand execute(Operand first, Operand second) {
        return null;
    }
}
