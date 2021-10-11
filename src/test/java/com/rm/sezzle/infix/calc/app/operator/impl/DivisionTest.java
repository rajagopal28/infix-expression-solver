package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import org.junit.Assert;
import org.junit.Test;

public class DivisionTest {
    @Test
    public void testDivisionOperation() {
        Operator operator = new Division();
        Operand result = operator.execute(Operand.of("1"), Operand.of("2"));
        Assert.assertEquals(CalculatorAppConstants.DIVIDE_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.MULTI_DIVIDE_PRIORITY_TWO, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(0.5d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeDivisionOperation() {
        Operator operator = new Division();
        Operand result = operator.execute(Operand.of("3"), new Operand(-3d));
        Assert.assertEquals(CalculatorAppConstants.DIVIDE_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.MULTI_DIVIDE_PRIORITY_TWO, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(-1d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeDivisionOperation_Scenario2() {
        Operator operator = new Division();
        Operand result = operator.execute(new Operand(-2d), new Operand(-1d));
        Assert.assertEquals(CalculatorAppConstants.DIVIDE_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.MULTI_DIVIDE_PRIORITY_TWO, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeDivisionOperation_DecimalValues() {
        Operator operator = new Division();
        Operand result = operator.execute(new Operand(22d), new Operand(7d));
        Assert.assertEquals(CalculatorAppConstants.DIVIDE_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.MULTI_DIVIDE_PRIORITY_TWO, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(3.14285, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeDivisionOperation_DivideByZeroException() {
        Operator operator = new Division();
        try {
            operator.execute(new Operand(-2d), new Operand(0d));
        } catch (Exception ex) {
            Assert.assertEquals(CalculatorAppConstants.ERROR_DIVIDE_BY_ZERO, ex.getMessage());
        }
    }
}