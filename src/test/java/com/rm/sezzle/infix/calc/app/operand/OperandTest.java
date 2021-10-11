package com.rm.sezzle.infix.calc.app.operand;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import org.junit.Assert;
import org.junit.Test;

public class OperandTest {
    @Test
    public void testOperandCreation() {
        Operand o = new Operand(1.0d);
        Assert.assertEquals(1.0d, o.getValue(), 0.0001);
    }

    @Test
    public void testValidateOperandToken() {
        Assert.assertFalse(Operand.validate("12.34re243"));
        Assert.assertTrue(Operand.validate("12"));
        Assert.assertTrue(Operand.validate("12.34243"));
    }

    @Test
    public void testParseOperandTokenSuccess() {
        Operand o1 = Operand.of("12");
        Operand o2 = Operand.of("12.3242");
        Operand o3 = Operand.of("12.2312");
        Operand o4 = Operand.of("1224334");
        Assert.assertEquals(12d, o1.getValue(), 0.00001);
        Assert.assertEquals(12.3242d, o2.getValue(), 0.00001);
        Assert.assertEquals(12.2312d, o3.getValue(), 0.00001);
        Assert.assertEquals(1224334d, o4.getValue(), 0.00001);
    }

    @Test
    public void testParseOperandTokenFailure() {
        try {
            Operand.of("12dfa");
        } catch (Exception ex) {
            Assert.assertEquals(CalculatorAppConstants.ERROR_INVALID_NUMBER,ex.getMessage());
        }

        try {
            Operand.of("");
        } catch (Exception ex) {
            Assert.assertEquals(CalculatorAppConstants.ERROR_INVALID_NUMBER,ex.getMessage());
        }
    }
}