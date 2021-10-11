package com.rm.sezzle.infix.calc.app.operator.factory;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import com.rm.sezzle.infix.calc.app.operator.impl.Addition;
import com.rm.sezzle.infix.calc.app.operator.impl.Division;
import com.rm.sezzle.infix.calc.app.operator.impl.Multiplication;
import com.rm.sezzle.infix.calc.app.operator.impl.Subtraction;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private static Map<String, Operator> operatorMap = new HashMap<>();
    static {
        operatorMap.put(CalculatorAppConstants.ADD_OPERATOR, new Addition());
        operatorMap.put(CalculatorAppConstants.SUB_OPERATOR, new Subtraction());
        operatorMap.put(CalculatorAppConstants.MULTIPLY_OPERATOR, new Multiplication());
        operatorMap.put(CalculatorAppConstants.DIVIDE_OPERATOR, new Division());
    }

    public static Operator getOperator(String symbol) {
        if(!operatorMap.containsKey(symbol)) {
            throw new RuntimeException(CalculatorAppConstants.ERROR_OPERATOR_NOT_FOUND.apply(symbol));
        }
        return operatorMap.get(symbol);
    }
}
