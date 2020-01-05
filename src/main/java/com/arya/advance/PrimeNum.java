package com.arya.advance;

public class PrimeNum {

    public static void main(String[] args) {

        int num = 20;

        for (int i = 1; i <= num; i++) {

            int count = 0;

            for (int j = 1; j <= i; j++) {

                if (i % j == 0)
                    count++;
            }

            if (count == 2)
                System.out.println(i + " ");

        }

    }
}
