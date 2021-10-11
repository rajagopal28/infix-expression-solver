package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import org.junit.Assert;
import org.junit.Test;

public class BracketsTest {
    @Test
    public void testBracketsCreation() {
        Operator open = new OpenBracket("{");
        Operator close = new CloseBracket("]");
        Assert.assertEquals("{", open.getSymbol());
        Assert.assertEquals("]", close.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.OPEN_BRACKETS_PRIORITY_ZERO, open.getPriority());
        Assert.assertEquals(CalculatorAppConstants.CLOSE_BRACKETS_PRIORITY_FOUR, close.getPriority());
        Assert.assertNull(open.execute(null, null));
        Assert.assertNull(close.execute(null, null));
    }
}
