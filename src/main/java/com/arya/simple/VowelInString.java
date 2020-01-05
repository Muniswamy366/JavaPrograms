package com.arya.simple;

public class VowelInString {

    public static void main(String[] args) {

        String name = "muni swamy";
		
		/*for(int i=0;i<name.length();i++)
		{
			if(name.charAt(i)=='a' || name.charAt(i)=='e' || name.charAt(i)=='i' || name.charAt(i)=='o' || name.charAt(i)=='u')
				System.out.println(name.charAt(i));
		}*/

        for (char c : name.toCharArray()) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println(c);
                    break;
                default:
                    // no count increment
            }

        }

    }

}
