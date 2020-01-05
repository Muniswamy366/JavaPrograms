package com.arya.simple;

public class MaxTwoNumInArray {

    public static void main(String[] args) {

        int[] num = {5, 34, 78, 2, 45, 1, 99, 23};
        MaxTwoNumInArray tmn = new MaxTwoNumInArray();
        tmn.printTwoMaxNumbers(num);

    }

    public void printTwoMaxNumbers(int[] nums) {

        int firstMax = 0;
        int secondMax = 0;
        int thirdMax = 0;

        // or use quick sort then find element.

        for (int i = 0; i < nums.length; i++) {

            if (firstMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (secondMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (thirdMax < nums[i]) {
                thirdMax = nums[i];
            }

        }

        System.out.println("First Max Number: " + firstMax);
        System.out.println("Second Max Number: " + secondMax);
        System.out.println("Second Max Number: " + thirdMax);

    }

}
