package com.arya.advance;

public class DuplicateNumArray {

    public DuplicateNumArray() {
    }

    public static void main(String[] args) {

        int[] values = {2, 4, 2, 6, 4, 4};
        int[] temp = new int[128];
        int max = 0;

        for (int i = 0; i < values.length; i++) {
            temp[values[i]] = ++temp[values[i]];
            if (max < temp[values[i]])
                max = temp[values[i]];
        }

        for (int i = 0; i < values.length; i++) {
            if (temp[values[i]] == max)
                System.out.println(values[i] + " is repeted " + temp[values[i]] + " times.");
        }

    }

}
