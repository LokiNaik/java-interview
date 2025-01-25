package com.java.interview.arrays;

/**
 * Calculate the sum of all elements in an array.
 */

public class SumOfElementsInArray {

    public static void main(String[] args) {
        int[] arr = {1, 5, 0, 4, 5, 1, 1, 4, 0};
        System.out.println(sumOfElementsInArray(arr));
    }

    public static int sumOfElementsInArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
