package com.arya.simple;

public class LeaderInArray {

    public static void main(String[] args) {

        int[] arr = new int[]{16, 17, 4, 3, 5, 2};
        int leader = arr[arr.length - 1];

        System.out.println(leader);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > leader) {
                leader = arr[i];
                System.out.println(leader);
            }
        }

    }
}
