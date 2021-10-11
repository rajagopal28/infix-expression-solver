package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import org.junit.Assert;
import org.junit.Test;

public class SubtractionTest {
    @Test
    public void testSubtractionOperation() {
        Operator operator = new Subtraction();
        Operand result = operator.execute(Operand.of("1"), Operand.of("2"));
        Assert.assertEquals(CalculatorAppConstants.SUB_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.ADD_SUB_PRIORITY_ONE, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(-1d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeSubtractionOperation() {
        Operator operator = new Subtraction();
        Operand result = operator.execute(Operand.of("2"), new Operand(-3d));
        Assert.assertEquals(CalculatorAppConstants.SUB_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.ADD_SUB_PRIORITY_ONE, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(5d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeSubtractionOperationScenario2() {
        Operator operator = new Subtraction();
        Operand result = operator.execute(new Operand(-3d), Operand.of("2"));
        Assert.assertEquals(CalculatorAppConstants.SUB_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.ADD_SUB_PRIORITY_ONE, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(-5d, result.getValue(), 0.001d);
    }
}