package com.arya.advance;

class Animal {
    void makeNoise() {
        System.out.println("generic noise");
    }
}

class Dog extends Animal {

    void playDead() {
        System.out.println("roll over");
    }
}

class CastTest {
    public static void main(String[] args) {

        Dog d = new Dog();
        Animal a1 = d; // upcast ok with no explicit cast
        Animal a2 = d;
        a1.makeNoise();

    }
}