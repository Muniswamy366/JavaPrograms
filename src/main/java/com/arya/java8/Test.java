package com.arya.java8;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(0, 0, 0, 0, 0);
        List<Integer> sub = Arrays.asList(100);


        int[] arr = new int[5];

        Arrays.fill(arr, 1 - 1, 2, 100);
        System.out.println(Arrays.toString(arr));


    }
}
