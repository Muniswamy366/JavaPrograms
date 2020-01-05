package com.arya.simple;

public class ExecutionTest {

	/*  1. static variables
		2. static block
		3. instance variables
		4. instance block
		5. constructor
	 */

    private static int a = m1();

    static {
        System.out.println("static block");
        //m1();
    }

    private int b = m2();

    {
        System.out.println("instance block");
    }

    ExecutionTest() {
        System.out.println("contructor");
    }

    public static int m1() {
        System.out.println("static method");
        return 1;
    }

    public static void main(String[] args) {
        ExecutionTest et = new ExecutionTest();
    }

    public int m2() {
        System.out.println("instance method");
        return 2;
    }

}
