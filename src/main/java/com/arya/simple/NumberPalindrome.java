package com.arya.simple;

public class NumberPalindrome {

    public static void main(String[] args) {

        int num = 121;

        int result = reverse(num);

        if (result == num)
            System.out.println("palindrome");
        else
            System.out.println("not palindrome");

    }

    private static int reverse(int number) {
        int reverse = 0;

        while (number != 0) {
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }

        return reverse;
    }

}
