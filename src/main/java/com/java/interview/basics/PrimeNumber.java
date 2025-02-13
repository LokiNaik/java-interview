package com.java.interview.basics;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrime(10));

        printPrime(10);

        printUpToNprime(10);
    }

    public static boolean isPrime(int n) {
        if (n < 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int sqrt = (int) Math.sqrt(n);
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrime(int n) {
        System.out.print("1 ");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void printUpToNprime(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
            }
        }
    }
}
