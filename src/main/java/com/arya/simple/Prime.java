package com.arya.simple;

public class Prime {

    public static void main(String[] args) {
		/*int a = 5,count=0;
		
		for(int i=2;i<a;i++)
		{
			if(a%2==0)
				count++;
		}
		
		if(count==0)
			System.out.println(a+" is prime");
		else
			System.out.println("not a prime");
		System.out.println(count);*/

        int n = 20, count = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % 2 == 0)
                    count++;
            }
            if (count == 0)
                System.out.println(i + " ");
            count = 0;
        }


    }

}
