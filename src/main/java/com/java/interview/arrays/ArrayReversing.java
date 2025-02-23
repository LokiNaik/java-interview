package com.java.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Reverse a given Array.
 *
 * Here, swap the elements from left to right by incrementing Left and decreasing Right until all the elements are sorted.
 */
public class ArrayReversing {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};


        // reverse up n digit.
        int reversedArray[] = reverseArrayUptoNDigit(arr, 5);
        for (int i : reversedArray){
            System.out.print(i + " ");
        }


        int[] reverse = reverse(arr);
        for (int i = 0; i < reverse.length; i++) {
            System.out.print(reverse[i] + " ");
        }

        // Using collections reversing a array.
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        reverseUsingCollections(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+ " ");
        }
    }

    /**
     * This method is to reverse a array upto N number without touching other numbers.
     *
     * Question asked in TCS.
     */
    public static int[] reverseArrayUptoNDigit(int[] array, int n){
        int start = 0;
        while(start < n){ // Iterate up N, without touching the remaining elements.
            int temp = array[start];
            array[start] = array[n];
            array[n] = temp;
            start++;
            n--;
        }
        return array;
    }

    /**
     * This is traditional method of reversing a string using the swap approach.
     * @param arr
     * @return
     */
    public static int[] reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    /**
     * Reverse a array using Collections.
     */
    public static void reverseUsingCollections(List<Integer> arr) {
        Collections.reverse(arr);
    }
}
