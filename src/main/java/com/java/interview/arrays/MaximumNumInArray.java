package com.java.interview.arrays;

/**
 * Find the maximum element in the Array.
 */
public class MaximumNumInArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 4, 5, 6, 18, 8, 9};
        System.out.println("Max Integer : "+ maxNumInArray(arr));
    }

    public static int maxNumInArray(int[] nums) {
        int temp = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
                if (temp < nums[i]) {
                    temp = nums[i];
            }
        }
        return temp;
    }

}
