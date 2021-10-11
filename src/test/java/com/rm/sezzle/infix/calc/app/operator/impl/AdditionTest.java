package com.rm.sezzle.infix.calc.app.operator.impl;

import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import org.junit.Assert;
import org.junit.Test;

public class AdditionTest {
    @Test
    public void testAdditionOperation() {
        Operator add = new Addition();
        Operand result = add.execute(Operand.of("1"), Operand.of("2"));
        Assert.assertEquals("+", add.getSymbol());
        Assert.assertEquals(1, add.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(3d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativeAdditionOperation() {
        Operator add = new Addition();
        Operand result = add.execute(new Operand(-3d), Operand.of("2"));
        Assert.assertEquals("+", add.getSymbol());
        Assert.assertEquals(1, add.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(-1d, result.getValue(), 0.001d);
    }
}