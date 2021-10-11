package com.rm.sezzle.infix.calc.app.operator.impl;


import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import org.junit.Assert;
import org.junit.Test;

public class ExponentiationTest {
    @Test
    public void testPowerOperation() {
        Operator operator = new Exponentiation();
        Operand result = operator.execute(Operand.of("2"), Operand.of("3"));
        Assert.assertEquals(CalculatorAppConstants.POWER_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.POWER_PRIORITY_THREE, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(8d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativePowerOperation() {
        Operator operator = new Exponentiation();
        Operand result = operator.execute(Operand.of("2"), new Operand(-3d));
        Assert.assertEquals(CalculatorAppConstants.POWER_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.POWER_PRIORITY_THREE, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(0.125d, result.getValue(), 0.001d);
    }

    @Test
    public void testDecimalPowerOperationScenario() {
        Operator operator = new Exponentiation();
        Operand result = operator.execute(new Operand(10d), new Operand(0.2d));
        Assert.assertEquals(CalculatorAppConstants.POWER_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.POWER_PRIORITY_THREE, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(1.5848d, result.getValue(), 0.001d);
    }

    @Test
    public void testDecimalPowerOperationScenario2() {
        Operator operator = new Exponentiation();
        Operand result = operator.execute(new Operand(2.2d), new Operand(1.8d));
        Assert.assertEquals(CalculatorAppConstants.POWER_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.POWER_PRIORITY_THREE, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertEquals(4.1339d, result.getValue(), 0.001d);
    }

    @Test
    public void testNegativePowerOperationScenario2_ShouldGetNaNForImaginaryPowers() {
        Operator operator = new Exponentiation();
        Operand result = operator.execute(new Operand(-1.2d), new Operand(-2.2d));
        Assert.assertEquals(CalculatorAppConstants.POWER_OPERATOR, operator.getSymbol());
        Assert.assertEquals(CalculatorAppConstants.POWER_PRIORITY_THREE, operator.getPriority());
        Assert.assertNotNull(result);
        Assert.assertTrue(Double.isNaN(result.getValue()));
    }
}