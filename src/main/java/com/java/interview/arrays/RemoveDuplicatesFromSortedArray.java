package com.java.interview.arrays;

import java.util.Arrays;

/**
 * Remove the elements from a Sorted Array to make the array elements unique.
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4};
        int newLength = removeDuplicates(arr);
        System.out.println(Arrays.toString(Arrays.copyOf(arr,  newLength)));
    }

    /**
     * Here the below code we compare the second index with the first index and if not equal we replace the present
     * index with the new value so that the array is sorts and we also return the unique index which is count of unique numbers
     * that helps us in the building the new array.
     * @param nums Array of Integers.
     * @return Integer
     */
    public static int removeDuplicates(int[] nums) {
        if(nums ==null || nums.length == 0){
            return 0;
        }
        int uniqueIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }
        return uniqueIndex;
    }
}
