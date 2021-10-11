package com.rm.sezzle.infix.calc.app.operator.factory;


import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import com.rm.sezzle.infix.calc.app.operator.impl.Addition;
import org.junit.Assert;
import org.junit.Test;

public class OperatorFactoryTest {

    @Test
    public void testExitingOperatorGet() {
        Operator o = OperatorFactory.getOperator(CalculatorAppConstants.ADD_OPERATOR);
        Assert.assertNotNull(o);
        Assert.assertTrue(o instanceof Addition);
    }

    @Test
    public void testUnknownOperatorGet_ExceptionHandling() {
        try {
            OperatorFactory.getOperator("?");
        } catch (Exception ex) {
            Assert.assertEquals(CalculatorAppConstants.ERROR_OPERATOR_NOT_FOUND.apply("?"), ex.getMessage());
        }
    }
}