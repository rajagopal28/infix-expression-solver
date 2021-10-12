package com.rm.sezzle.infix.calc.app.operator.factory;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.exception.OperationNotImplementedException;
import com.rm.sezzle.infix.calc.app.operator.Operator;
import com.rm.sezzle.infix.calc.app.operator.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * OperatorFactory creates and passes on valid operators.<br/>
 * It keeps track of all the operations that are implemented in the system. <br/>
 * Follows <b>Factory Method <i>Creational</i> Pattern</b>  from Object Oriented Design strategies.<br/>
 *
 * @author Rajagopal M
 *
 */
public class OperatorFactory {
    private static final Map<String, Operator> operatorMap = new HashMap<>();

    /*
    * Static initialisation of all the valid operation that are permissible in the system.<br/>
    * This is the only implementation point that needs change from the applciation point of view.<br/>
    *
    * */
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

    /**
     * Factory method that check and returns a Operator related to the given Operator Symbol. <br/>
     * If not found it throws <b>OperationNotImplementedException</b>.
     *
     * @param symbol String form of the particular Operator
     * @return Operator value based on the given Operator Symbol
     */
    public static Operator getOperator(String symbol) {
        if(!operatorMap.containsKey(symbol)) {
            throw new OperationNotImplementedException(symbol);
        }
        return operatorMap.get(symbol);
    }
}
