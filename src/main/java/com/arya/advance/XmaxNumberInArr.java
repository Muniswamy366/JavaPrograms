package com.arya.advance;

public class XmaxNumberInArr {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 48, 5, 26, 9, 78, 23,};

        int FirstMax = arr[0];
        int SecondMax = arr[0];
        int ThirdMax = arr[0];

        for (int i : arr) {

            if (FirstMax < i) {
                ThirdMax = SecondMax;
                SecondMax = FirstMax;
                FirstMax = i;

            } else if (SecondMax < i)
                SecondMax = i;
            else if (ThirdMax < i)
                ThirdMax = i;

        }

        System.out.println("first max " + FirstMax + " second max " + SecondMax + " third max " + ThirdMax);

    }
}
