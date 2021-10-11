package com.rm.sezzle.infix.calc.app.operand;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Operand {
    private Double value;

    private static final String DECIMAL_REGEX = "^\\d+\\.?\\d*$";

    public static Operand of(String token) {
        if(validate(token)) {
            return new Operand(Double.parseDouble(token));
        } else {
           throw new RuntimeException("Not a valid number!");
        }
    }

    public static boolean validate(String token) {
        return token.matches(DECIMAL_REGEX);
    }
}
