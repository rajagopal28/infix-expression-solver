package com.rm.sezzle.infix.calc.app.operator.factory;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import com.rm.sezzle.infix.calc.app.operator.impl.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private static final Map<String, Operator> operatorMap = new HashMap<>();
    static {
        operatorMap.put(CalculatorAppConstants.ADD_OPERATOR, new Addition());
        operatorMap.put(CalculatorAppConstants.SUB_OPERATOR, new Subtraction());
        operatorMap.put(CalculatorAppConstants.MULTIPLY_OPERATOR, new Multiplication());
        operatorMap.put(CalculatorAppConstants.DIVIDE_OPERATOR, new Division());
        operatorMap.put(CalculatorAppConstants.POWER_OPERATOR, new Exponentiation());
        CalculatorAppConstants.BRACKET_PAIRS.forEach((k, v) -> {
            operatorMap.put(k, new CloseBracket(k));
            operatorMap.put(v, new OpenBracket(v));
        });
    }

    public static Operator getOperator(String symbol) {
        if(!operatorMap.containsKey(symbol)) {
            throw new RuntimeException(CalculatorAppConstants.ERROR_OPERATOR_NOT_FOUND.apply(symbol));
        }
        return operatorMap.get(symbol);
    }
}
