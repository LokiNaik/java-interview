package com.java.interview.arrays;

/**
 * Find the Minimum element in the given array
 */
public class MinimumInArray {

    public static void main(String[] args) {
        int[] arr = {1, 5, 0, 4, 5, 1, 1, 4, 0};
        System.out.println("Minimum number is: " + minimumInArray(arr));
    }

    public static int minimumInArray(int[] arr) {
        int len = arr.length;
        int min = arr[0];  // [1,5,0,4,6,7]
        for (int i = 1; i < len; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}
