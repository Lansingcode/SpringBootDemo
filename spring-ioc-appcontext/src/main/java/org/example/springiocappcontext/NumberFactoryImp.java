package org.example.springiocappcontext;

import java.math.BigDecimal;

public class NumberFactoryImp implements NumberFactory {
    @Override
    public Number parseNumber(String number) {
        return new BigDecimal(number);
    }
}
