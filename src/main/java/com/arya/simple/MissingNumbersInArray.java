package com.arya.simple;

public class MissingNumbersInArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 10};

        int n = arr.length;
        int sum = (n + 1) * (n + 2) / 2;

        for (int i = 0; i < n; i++)
            sum = sum - arr[i];
        System.out.println(sum);
		
		/*int n = arr.length;
		int x1 = arr[0];  For xor of all the elemets in arary 
	    int x2 = 1;  For xor of all the elemets from 1 to n+1 
		for (int i = 1; i< n; i++)
	        x1 = x1^arr[i];
	            
	    for (int i = 2; i <= n+1; i++)
	        x2 = x2^i;         
	    
	    System.out.println(x1^x2);*/
    }

}
