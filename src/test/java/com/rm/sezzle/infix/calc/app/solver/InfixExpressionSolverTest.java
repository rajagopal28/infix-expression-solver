package com.rm.sezzle.infix.calc.app.solver;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.exception.InvalidExpressionException;
import com.rm.sezzle.infix.calc.app.exception.MalformedBracketsException;
import com.rm.sezzle.infix.calc.app.exception.OperationNotImplementedException;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import org.junit.Assert;
import org.junit.Test;

public class InfixExpressionSolverTest {

    @Test
    public void testSimpleExpressionWithOneOperator() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        Operand sum = solver.solve("1+2");
        Operand diff = solver.solve("1-2");
        Operand prod = solver.solve("1*2");
        Operand quotient = solver.solve("1/2");
        Assert.assertNotNull(sum);
        Assert.assertEquals(3, sum.getValue(), 0.001);
        Assert.assertNotNull(diff);
        Assert.assertEquals(-1, diff.getValue(), 0.001);
        Assert.assertNotNull(prod);
        Assert.assertEquals(2, prod.getValue(), 0.001);
        Assert.assertNotNull(quotient);
        Assert.assertEquals(0.5, quotient.getValue(), 0.001);
    }


    @Test
    public void testSimpleExpressionWithTwoSimilarOperation_SamePriority() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        Operand result1 = solver.solve("1+2-1");
        Operand result2 = solver.solve("1+2-5");
        Operand result3 = solver.solve("1*4/2");
        Operand result4 = solver.solve("1/2*5");
        Assert.assertNotNull(result1);
        Assert.assertEquals(2, result1.getValue(), 0.001);
        Assert.assertNotNull(result2);
        Assert.assertEquals(-2, result2.getValue(), 0.001);
        Assert.assertNotNull(result3);
        Assert.assertEquals(2, result3.getValue(), 0.001);
        Assert.assertNotNull(result4);
        Assert.assertEquals(2.5, result4.getValue(), 0.001);
    }


    @Test
    public void testSimpleExpressionWithTwoDifferentOperation_DifferentPriority() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        Operand result1 = solver.solve("36/6*3-4+8");
        Operand result2 = solver.solve("30/5+4*2-14");
        Assert.assertNotNull(result1);
        Assert.assertEquals(22, result1.getValue(), 0.001);
        Assert.assertNotNull(result2);
        Assert.assertEquals(0, result2.getValue(), 0.001);
    }

    @Test
    public void testSimpleExpressionWithTwoDifferentOperation_DifferentPriority_PowerOperator() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        Operand result1 = solver.solve("36/6*3-2^2+8");
        Operand result2 = solver.solve("30/5+2^2*2-14");
        Assert.assertNotNull(result1);
        Assert.assertEquals(22, result1.getValue(), 0.001);
        Assert.assertNotNull(result2);
        Assert.assertEquals(0, result2.getValue(), 0.001);
    }


    @Test
    public void testSimpleExpressionWithTwoDifferentOperation_DifferentPriority_Braces() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        Operand result1 = solver.solve("2*(5+1)/3");
        Operand result2 = solver.solve("4/(2^2)-1+8+[30/10]");
        Assert.assertNotNull(result1);
        Assert.assertEquals(4, result1.getValue(), 0.001);
        Assert.assertNotNull(result2);
        Assert.assertEquals(11, result2.getValue(), 0.001);
    }

    @Test
    public void testSimpleExpressionWithOneNumber() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        Operand result = solver.solve("2");
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.getValue(), 0.001);
    }

    @Test
    public void testExceptionSimpleExpressionWith_InvalidOperator() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        try {
            solver.solve("5 | 1");
            Assert.fail("Should not come here!");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof OperationNotImplementedException);
            Assert.assertEquals(CalculatorAppConstants.ERROR_OPERATOR_NOT_FOUND.apply("|"), ex.getMessage());
        }
    }

    @Test
    public void testExceptionSimpleExpressionWith_BlankExpression() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        try {
            solver.solve(" ");
            Assert.fail("Should not come here!");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof InvalidExpressionException);
            Assert.assertEquals(CalculatorAppConstants.ERROR_INVALID_EXPRESSION_FORMATION, ex.getMessage());
        }
    }

    @Test
    public void testExceptionSimpleExpressionWith_MoreOperatorThanOperands() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        try {
            solver.solve("-");
            Assert.fail("Should not come here!");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof InvalidExpressionException);
            Assert.assertEquals(CalculatorAppConstants.ERROR_INVALID_EXPRESSION_FORMATION, ex.getMessage());
        }

        try {
            solver.solve("+2*4"); // more operator than number
            Assert.fail("Should not come here!");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof InvalidExpressionException);
            Assert.assertEquals(CalculatorAppConstants.ERROR_INVALID_EXPRESSION_FORMATION, ex.getMessage());
        }
    }

    @Test
    public void testExceptionSimpleExpressionWith_MoreOperandsThanOperator() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        try {
            solver.solve("2+3 4"); // more number than operator
            Assert.fail("Should not come here!");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof InvalidExpressionException);
            Assert.assertEquals(CalculatorAppConstants.ERROR_INVALID_EXPRESSION_FORMATION, ex.getMessage());
        }
    }

    @Test
    public void testExceptionSimpleExpressionWith_InvalidBraces() {
        InfixExpressionSolver solver = new InfixExpressionSolver();
        try {
            solver.solve("[2+3}"); // more number than operator
            Assert.fail("Should not come here!");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof MalformedBracketsException);
            Assert.assertEquals(CalculatorAppConstants.ERROR_BRACKETS_NOT_PROPERLY_FORMED, ex.getMessage());
        }

        try {
            solver.solve("]2+3["); // more number than operator
            Assert.fail("Should not come here!");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof MalformedBracketsException);
            Assert.assertEquals(CalculatorAppConstants.ERROR_BRACKETS_NOT_PROPERLY_FORMED, ex.getMessage());
        }

        try {
            solver.solve("([2+3]))"); // more number than operator
            Assert.fail("Should not come here!");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof MalformedBracketsException);
            Assert.assertEquals(CalculatorAppConstants.ERROR_BRACKETS_NOT_PROPERLY_FORMED, ex.getMessage());
        }
    }

}