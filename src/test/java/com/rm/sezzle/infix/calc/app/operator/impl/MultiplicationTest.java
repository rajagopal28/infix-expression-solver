package com.rm.sezzle.infix.calc.app.operator.impl;


import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import org.junit.Assert;
import org.junit.Test;

public class MultiplicationTest {
    @Test
    public void testMultiplicationOperation() {
        Operator add = new Multiplication();
        Operand result = add.execute(Operand.of("1"), Operand.of("2"));
        Assert.assertEquals("*", add.getSymbol());
        Assert.assertEquals(2, add.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(2d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeMultiplicationOperation() {
        Operator add = new Multiplication();
        Operand result = add.execute(Operand.of("2"), new Operand(-3d));
        Assert.assertEquals("*", add.getSymbol());
        Assert.assertEquals(2, add.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(-6d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeMultiplicationOperationScenario2() {
        Operator add = new Multiplication();
        Operand result = add.execute(new Operand(-1.2d), new Operand(-2.2d));
        Assert.assertEquals("*", add.getSymbol());
        Assert.assertEquals(2, add.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(2.64, result.getValue(), 0.001d);
    }
}