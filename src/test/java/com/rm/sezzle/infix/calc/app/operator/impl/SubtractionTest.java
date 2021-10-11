package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import org.junit.Assert;
import org.junit.Test;

public class SubtractionTest {
    @Test
    public void testSubtractionOperation() {
        Operator add = new Subtraction();
        Operand result = add.execute(Operand.of("1"), Operand.of("2"));
        Assert.assertEquals("-", add.getSymbol());
        Assert.assertEquals(1, add.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(-1d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeSubtractionOperation() {
        Operator add = new Subtraction();
        Operand result = add.execute(Operand.of("2"), new Operand(-3d));
        Assert.assertEquals("-", add.getSymbol());
        Assert.assertEquals(1, add.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(5d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeSubtractionOperationScenario2() {
        Operator add = new Subtraction();
        Operand result = add.execute(new Operand(-3d), Operand.of("2"));
        Assert.assertEquals("-", add.getSymbol());
        Assert.assertEquals(1, add.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(-5d, result.getValue(), 0.001d);
    }
}