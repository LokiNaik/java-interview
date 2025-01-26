package com.java.interview.arrays;

/**
 * Rotate the array to right by K steps.
 */
public class RotateArrayByKsteps {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        RotateArrayByKsteps rotator = new RotateArrayByKsteps();
        rotator.rotate(arr, 3);
        for ( int array : arr){
            System.out.print(array + " ");
        }
    }

    /**
     * This method helps us in rotate the array.
     * @param arr Integer Array.
     * @param k No of elements to rotate.
     */
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;  // this gives the remainder which helps to how many terms array should be rotated if k is greater than array.length.

        reverse(arr, 0, n - 1); // reverse the complete array. eg {7,6,5,4,3,2,1}

        reverse(arr, 0, k - 1); // reverse the array upto k. eg {5,6,7,4,3,2,1}

        reverse(arr, k, n - 1); // reverse the remaining elements in a array. eg {5,6,7,1,2,3,4}, rotate is done.
    }

    /**
     * In order to rotate the array we have to reverse the array.
     * @param arr Integer array
     * @param left left index of array
     * @param right right index of array
     */
    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
