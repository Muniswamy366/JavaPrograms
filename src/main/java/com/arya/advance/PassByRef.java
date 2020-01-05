package com.arya.advance;

class PassByRef {
    int x = 5;

    public static void main(String[] args) {
        final PassByRef f1 = new PassByRef();
        PassByRef f2 = new PassByRef();
        PassByRef f3 = FizzSwitch(f1, f2);
        System.out.println(f1.x);
        System.out.println(f3.x);
        System.out.println((f1 == f3) + " " + (f1.x == f3.x));
    }

    static PassByRef FizzSwitch(PassByRef x, PassByRef y) {
        final PassByRef z = x;
        z.x = 6;
        return z;
    }
}