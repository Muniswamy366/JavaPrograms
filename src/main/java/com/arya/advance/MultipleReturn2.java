package com.arya.advance;

public class MultipleReturn2 {

    public static void main(String[] args) {
        MultipleReturn2 var = new MultipleReturn2();
        System.out.println("In Main:" + var.getStringBuilder());
    }

    StringBuilder getStringBuilder() {
        StringBuilder returnVal = new StringBuilder("10");
        try {
            String[] students = {"Harry", "Paul"};
            System.out.println(students[5]);
        } catch (Exception e) {
            System.out.println("About to return :" + returnVal);
            return returnVal;//value copy's but still returnVal and copyed value points to same object
        } finally {
            returnVal.append("10");//so object value will be changed.
            System.out.println("Return value is now :" + returnVal);
        }
        return returnVal;
    }
}