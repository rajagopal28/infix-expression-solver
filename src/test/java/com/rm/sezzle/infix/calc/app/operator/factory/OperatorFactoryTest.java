package com.rm.sezzle.infix.calc.app.operator.factory;


import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.exception.OperationNotImplementedException;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import com.rm.sezzle.infix.calc.app.operator.impl.Addition;
import com.rm.sezzle.infix.calc.app.operator.impl.CloseBracket;
import com.rm.sezzle.infix.calc.app.operator.impl.OpenBracket;
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
    public void testExitingOperatorGet_Brackets() {
        Operator o = OperatorFactory.getOperator("{");
        Operator c = OperatorFactory.getOperator("]");
        Assert.assertNotNull(o);
        Assert.assertNotNull(c);
        Assert.assertTrue(o instanceof OpenBracket);
        Assert.assertTrue(c instanceof CloseBracket);
    }

    @Test
    public void testUnknownOperatorGet_ExceptionHandling() {
        try {
            OperatorFactory.getOperator("?");
            Assert.fail("Should not come here!");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof OperationNotImplementedException);
            Assert.assertEquals(CalculatorAppConstants.ERROR_OPERATOR_NOT_FOUND.apply("?"), ex.getMessage());
        }
    }
}