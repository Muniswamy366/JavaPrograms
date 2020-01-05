package com.arya.simple;

public class DecimalToBinary {

    public static void main(String[] args) {

        int a = 10;
        StringBuffer sb = new StringBuffer();

        while (a != 0) {
            sb.append(a % 2);
            a = a / 2;
        }

        System.out.println(sb.reverse());
    }

}
