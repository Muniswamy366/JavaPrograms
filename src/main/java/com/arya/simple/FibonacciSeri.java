package com.arya.simple;

public class FibonacciSeri {

    public static void main(String[] args) {

        int num = 10;
        int[] a = new int[num];
        a[0] = 0;
        a[1] = 1;

        for (int i = 2; i < a.length; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }

        for (int i = 0; i < num; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
