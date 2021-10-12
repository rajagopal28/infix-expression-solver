package com.rm.sezzle.infix.calc.app.operand;

import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.exception.InvalidOperandFormatException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Operand {
    private double value;

    public static Operand of(String token) {
        if(validate(token)) {
            return new Operand(Double.parseDouble(token));
        } else {
           throw new InvalidOperandFormatException();
        }
    }

    public static boolean validate(String token) {
        return token.matches(CalculatorAppConstants.DECIMAL_REGEX);
    }
}
