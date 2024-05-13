package com.homeland.homeland.utilities;

import lombok.experimental.UtilityClass;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@UtilityClass
public class NumberFormatter {

    private static final DecimalFormat decimalFormat;

    static {
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
        formatSymbols.setGroupingSeparator('.');
        decimalFormat = new DecimalFormat("###,###", formatSymbols);
    }

    public static String numberToStringRupiah(long number) {
        return "Rp. " + decimalFormat.format(number);
    }
}
