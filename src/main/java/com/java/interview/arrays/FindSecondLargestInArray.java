package com.java.interview.arrays;

/**
 * Find the second-largest integer in the given Array.
 */
public class FindSecondLargestInArray {

    public static int secondLargestInArray(int[] arr) {

        if(arr == null || arr.length < 2){
            throw new IllegalArgumentException("Input array is null or empty");
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int  num : arr){
            if(num > first){
                second = first;
                first = num;
            } else if(num > second && num < first){
                second = num;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(secondLargestInArray(arr));
    }
}
