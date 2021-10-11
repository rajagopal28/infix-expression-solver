package com.rm.sezzle.infix.calc.app.operator;

import com.rm.sezzle.infix.calc.app.operand.Operand;
import org.junit.Assert;
import org.junit.Test;

public class OperatorTest {
    @Test
    public void testOperatorCreation() {
        Operator o = new Operator("x", 10) {
            @Override
            public Operand execute(Operand first, Operand second) {
                return null;
            }
        };
        Assert.assertEquals("x", o.getSymbol());
        Assert.assertEquals(10, o.getPriority());
    }

    @Test
    public void testOperatorExecution() {
        Operator o = new Operator("?", 100) {
            @Override
            public Operand execute(Operand first, Operand second) {
                return first;// returns the first operand
            }
        };
        Assert.assertEquals("?", o.getSymbol());
        Assert.assertEquals(100, o.getPriority());
        Operand f = Operand.of("1");
        Operand s = Operand.of("2");
        Assert.assertEquals(f, o.execute(f, s));// returns the first operand
    }
}