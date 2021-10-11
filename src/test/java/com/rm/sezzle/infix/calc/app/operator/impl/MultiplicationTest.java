package com.rm.sezzle.infix.calc.app.operator.impl;


import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import org.junit.Assert;
import org.junit.Test;

public class MultiplicationTest {
    @Test
    public void testMultiplicationOperation() {
        Operator operator = new Multiplication();
        Operand result = operator.execute(Operand.of("1"), Operand.of("2"));
        Assert.assertEquals(CalculatorAppConstants.MULTIPLY_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.MULTI_DIVIDE_PRIORITY_TWO, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(2d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeMultiplicationOperation() {
        Operator operator = new Multiplication();
        Operand result = operator.execute(Operand.of("2"), new Operand(-3d));
        Assert.assertEquals(CalculatorAppConstants.MULTIPLY_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.MULTI_DIVIDE_PRIORITY_TWO, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(-6d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeMultiplicationOperationScenario2() {
        Operator operator = new Multiplication();
        Operand result = operator.execute(new Operand(-1.2d), new Operand(-2.2d));
        Assert.assertEquals(CalculatorAppConstants.MULTIPLY_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.MULTI_DIVIDE_PRIORITY_TWO, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(2.64, result.getValue(), 0.001d);
    }
}