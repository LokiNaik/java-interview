package com.java.interview.arrays;

import java.util.PriorityQueue;

public class Practice {
    // array reversing
    /*
    public static void main(String[] args) {
        int arr[] = {5,8,6,9,5,2};
        int left = 0;
        int end = arr.length-1;
        while (left<end){
            int temp = arr[left];
            arr[left] = arr[end];
            arr[end] = temp;
            left++;
            end--;
        }
        for(int i:arr){
            System.out.print(i +", ");
        }
     }
*/
    // palindrome check
    /*
    public static void main(String[] args) {
        String string = "anana";
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                System.out.println(string + " is not a palindrome");
                return;
            }
            left++;
            right--;
        }
        System.out.println(string + " is a palindrome ");
    }
    */
    // Fibannoic
    /*
    public static void main(String[] args) {
        int count = 5;
        int a = 1;
        int b = 2;
        int ab;
        System.out.print("1, 2, ");
        while (count > 0) {
            ab = a + b;
            a = b;
            b = ab;
            count--;
            System.out.print(ab+", ");
        }
    }
*/
    // Second largest in array
    /*
        public static void main(String[] args) {
        int[] arr = {5, 8, 6, 2, 8, 9};
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            }
        }
        System.out.println(second);
    }
     */
    // First non repetitive
    /*
      public static void main(String[] args) {
        int array[] = {2,2,3};
        int result = 0;
        for(int num : array){
            result ^= num;
        }
        System.out.println(result);
    }
     */
    // Kth largest element

    public static void main(String[] args) {
        int k = 5;
//        int[] arr = {12, 15, 10, 16, 14, 16, 17, 18, 19};
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }

        return minHeap.peek();
    }

//    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 5, 6, 4};
////        int[] nums = {12, 15, 10, 16, 14, 16, 17, 18, 19};
//        int k = 2;
//        System.out.println("The " + k + "th largest element is " + findKthLargest(nums, k));
//    }

}
