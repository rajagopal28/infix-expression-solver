package com.rm.sezzle.infix.calc.app.solver;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.exception.InvalidExpressionException;
import com.rm.sezzle.infix.calc.app.exception.MalformedBracketsException;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import com.rm.sezzle.infix.calc.app.operator.factory.OperatorFactory;

import java.util.Stack;
import java.util.StringTokenizer;

/*
 * InfixExpressionSolver provides the backbone workflow that is involved in solving the infix expression given by the invoker.
 * It does not maintain any state, it works completely on a "on-demand" basis.
 *
 * @author Rajagopal M
 * */
public class InfixExpressionSolver {

    /**
     * Solve method implements the infix expression parsing and solving logic with the help of Stack data structure.<br/>
     * It applies Bodma's rule while evaluating the expression based on the priority of the Operation.<br/>
     * It throws exception at the runtime based on the execution data flow and touch-point involved.
     *
     * @param expression which should be parsed and solved by the application
     *
     * @return Operand on successful solving of the expression.
     */
    public Operand solve(String expression) {
        Stack<Operand> operandStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, CalculatorAppConstants.EXPRESSION_TOKENIZATION_DELIMITERS, true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!token.isBlank()) {
                if(Operand.validate(token)) { // Validate to be a numeric value
                    operandStack.push(Operand.of(token));
                } else if(CalculatorAppConstants.BRACKET_PAIRS.containsKey(token)) { // check for closed brackets
                    Operator matchingOpener = OperatorFactory.getOperator(CalculatorAppConstants.BRACKET_PAIRS.get(token));
                    while (!operatorStack.isEmpty() &&
                            !operatorStack.peek().equals(matchingOpener) &&
                            popAndExecuteOperation(operatorStack, operandStack));
                    if(operatorStack.isEmpty() || !operatorStack.peek().equals(matchingOpener)) {
                        // some other operator found instead of corresponding open braces
                        throw new MalformedBracketsException();
                    }
                    operatorStack.pop();// discard the matching open braces

                } else if(CalculatorAppConstants.BRACKET_PAIRS.containsValue(token)) { // opening braces so just push it
                    operatorStack.push(OperatorFactory.getOperator(token));
                } else { // it is an operator
                    Operator currentOperation = OperatorFactory.getOperator(token);
                    while (!operatorStack.isEmpty() &&
                            operatorStack.peek().getPriority() >= currentOperation.getPriority()
                        && popAndExecuteOperation(operatorStack, operandStack));
                    // re-use strategy where function executes and terminates loop at the end
                    operatorStack.push(currentOperation);
                }
            }
        }
        while (popAndExecuteOperation(operatorStack, operandStack));
        // re-use strategy where function executes and terminates loop at the end
        if(!operatorStack.isEmpty() || operandStack.size() !=1) {
            // better resource handling
            operandStack.clear();
            operatorStack.clear();
            throw new InvalidExpressionException();
        }
        Operand result = operandStack.pop();
        operandStack.clear(); // better resource handling
        return result;
    }

    /**
     * popAndExecuteOperation is a generic method that helps in applying operation on the current valid Operands.<br/>
     * It gives a continuity or break in flow decision based on further operation can be processed or not.
     *
     * @param operatorStack containing the list of valid operators present in the expression until parsing has happened.
     * @param operandStack containing the list of valid Operands present in the expression until parsing has happened.
     *
     * @return boolean value indicating whether any successful operation is performed based on the current data.
     */
    private boolean popAndExecuteOperation(Stack<Operator> operatorStack, Stack<Operand> operandStack) {
        if(!operatorStack.isEmpty() && operandStack.size() > 1) {// needs 2 operands
            Operator operation = operatorStack.pop();
            Operand first = operandStack.pop();
            Operand second = operandStack.pop();
            operandStack.push(operation.execute(second, first));
            return true;
        }
        return false;
    }
}
