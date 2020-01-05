package com.arya.simple;

public class PerfectNum {

    public static void main(String[] args) {
        int num = 6;
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum = sum + i;
            }
        }

        if (sum == num)
            System.out.println("perfect");
        else
            System.out.println("not perfect");
    }

}
