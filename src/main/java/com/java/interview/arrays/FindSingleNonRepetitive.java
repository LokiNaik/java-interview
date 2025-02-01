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
//    public static String findSingleNonRepetitive2(String string) {
//        char[] chars = string.toCharArray();
//        String result = null;
//        for (int i = 0; i < chars.length; i++) {
//            if ()
//        }
//        return "";
//    }

}
