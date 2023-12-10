package org.example.concepts.fibonacci;

public class FibDriver {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.recursiveFib(7));
//        System.out.println(fib.dynamicRecFib(7));
//        System.out.println(fib.dynamicFib(2));
    }
}
