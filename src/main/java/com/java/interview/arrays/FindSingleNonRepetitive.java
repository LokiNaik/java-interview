package com.java.interview.arrays;

public class FindSingleNonRepetitive {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1};
        System.out.println(findSingleNonRepetitive(arr));
    }

    public static int findSingleNonRepetitive(int[] arr) {

        int result = 0;
        for (int num : arr){
            result ^= num;
        }
        return result;
    }
}
