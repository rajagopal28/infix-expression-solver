package com.rm.sezzle.infix.calc.app.solver;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import com.rm.sezzle.infix.calc.app.operator.factory.OperatorFactory;

import java.util.Stack;
import java.util.StringTokenizer;

public class InfixExpressionSolver {
    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;

    public InfixExpressionSolver() {
        this.operandStack = new Stack<>();
        this.operatorStack = new Stack<>();
    }

    public Operand solve(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, CalculatorAppConstants.EXPRESSION_TOKENIZATION_DELIMITERS, true);
        while ( tokenizer.hasMoreTokens() ) {
            String token = tokenizer.nextToken();
            if (!token.isBlank()) {
                if(Operand.validate(token)) {
                    operandStack.push(Operand.of(token));
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
        return operandStack.pop();
    }

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
