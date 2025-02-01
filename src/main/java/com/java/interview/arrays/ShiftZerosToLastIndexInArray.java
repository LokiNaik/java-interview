package com.java.interview.arrays;

public class ShiftZerosToLastIndexInArray {

    public static void main(String[] args) {
        int[] arr = { 0, 2, 0, 4, 5, 0, 7, 8, 9, 10 };
        shiftZerosLastIndex(arr);
        shiftZerosToBeginning(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void shiftZerosLastIndex(int[] arr) {
            int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void shiftZerosToBeginning(int[] arr) {
        int j = arr.length - 1;
        for (int i = arr.length -1 ; i >= 0;i--)  {
            if (arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

}
