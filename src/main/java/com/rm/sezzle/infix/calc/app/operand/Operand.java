package com.rm.sezzle.infix.calc.app.operand;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.exception.InvalidOperandFormatException;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Operand class that holds the information of the data upon which the operation is applied.
 *
 * @author Rajagopal M
 *
 */
@AllArgsConstructor
@Getter
public class Operand {
    private double value;


    /**
     * Operand.of method gives a new Operand instance parsed from the given token with proper validation
     *
     * @param token
     * @return Operand formed from the given token
     */
    public static Operand of(String token) {
        if(validate(token)) {
            return new Operand(Double.parseDouble(token));
        } else {
           throw new InvalidOperandFormatException();
        }
    }

    /**
     * Operand.validate method validates the format of given string is numeric
     *
     * @param token
     * @return boolean value of whether the given string is valid token
     */
    public static boolean validate(String token) {
        return token.matches(CalculatorAppConstants.DECIMAL_REGEX);
    }
}
