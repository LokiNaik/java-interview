package com.java.interview.basics;

public class FibannoicSeries {
    public static void main(String[] args) {
        fib(5);
    }

    public static void fib(int n) {
        int a = 1;
        int b = 2;
        int ab;
        System.out.print("1, 2, ");
        for (int i = n; i > 0; i--) {
            ab = a + b;
            a = b;
            b = ab;
            System.out.print(ab + ", ");
        }
    }
}
