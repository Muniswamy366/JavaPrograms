package com.arya.simple;

public class BinToDecimal {

    public static void main(String[] args) {

        String a = "0111";
        String c = "10";

        int b = Integer.parseInt(a, 2);
        int d = Integer.parseInt(c, 2);

        // Binary to Decimal
        System.out.println(b);
        // Decimal to Binary
        System.out.println(d);
    }

}
