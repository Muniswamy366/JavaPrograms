package com.arya.simple;

import java.util.*;
import java.util.stream.Collectors;

public class CommonElementsInArray {

    public static void main(String[] args) {
        int[] arr1 = {4, 7, 3, 9, 2};
        int[] arr2 = {3, 2, 12, 9, 40, 32, 4};
        bruteForce(arr1, arr2);

        Integer[] arr3 = new Integer[]{4, 7, 3, 9, 2, 6};
        Integer[] arr4 = new Integer[]{3, 2, 12, 9, 40, 32, 4};

        usingSet(arr3, arr4);
        usingRetainAll(arr3, arr4);
        findCommonJava8(arr3, arr4);
        findUnCommonJava8(arr3, arr4);
    }

    private static void bruteForce(int[] arr1, int[] arr2) {
        System.out.println("bruteForce");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i]);
                }
            }
        }

        System.out.println();
    }

    private static void usingSet(Integer[] arr1, Integer[] arr2) {
        System.out.println("usingSet");
        Set<Integer> set1 = new LinkedHashSet<Integer>(Arrays.asList(arr1));
        Set<Integer> set2 = new LinkedHashSet<Integer>(Arrays.asList(arr2));

        Set<Integer> collect = set1.stream()
                .filter(ele -> !set2.add(ele))
                .collect(Collectors.toSet());
        System.out.println(collect);
    }

    private static void usingRetainAll(Integer[] arr3, Integer[] arr4) {
        System.out.println("usingRetainAll");
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(arr3));
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(arr4));

        list1.retainAll(list2);
        System.out.println(list1);
    }

    private static void findCommonJava8(Integer[] first, Integer[] second) {
        System.out.println("findCommonJava8");
        List<Integer> otherList = Arrays.stream(second).collect(Collectors.toList());
        Set<Integer> collect = Arrays.stream(first)
                .distinct()
                .filter(otherList::contains)
                .collect(Collectors.toSet());
        System.out.println(collect);
    }

    private static void findUnCommonJava8(Integer[] first, Integer[] second) { // doesn't display all elements
        System.out.println("findUnCommonJava8");
        List<Integer> otherList = Arrays.stream(second).collect(Collectors.toList());
        Set<Integer> collect = Arrays.stream(first)
                .distinct()
                .filter(num -> !otherList.contains(num))
                .collect(Collectors.toSet());
        System.out.println(collect);
    }
}
