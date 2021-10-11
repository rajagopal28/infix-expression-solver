package com.rm.sezzle.infix.calc.app.solver;

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
}