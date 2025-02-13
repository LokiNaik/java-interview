package com.java.interview.arrays;

import java.util.PriorityQueue;

/**
 * Implement a logic to find the K th Largest element in a Array.
 * we can implement this using the heap size of a element.
 */
public class KthLargestElementInArray {
    public static void main(String[] args) {
//        int[] arr = { 12, 15, 10, 16, 14, 16, 17, 18, 19 };
        int[] arr = {5, 8, 6, 5, 2, 7, 3, 4};
        System.out.println(kthLargestElementInArray(arr, 3));
    }


    /**
     * This method use PriorityQueue this holds the elements unto k th place and from that return the max number using .peek() method.
     *
     * @param arr Integer Array
     * @param k   Integer
     * @return Integer
     */
    public static int kthLargestElementInArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // removes the lowest size from the heap.
            }
        }
        return minHeap.peek(); // Returns the highest value.
    }

    public int kThLargest(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>(k);
        for (int num : nums) {
            if(min.size() < k){
                min.add(num);
            } else if (num > min.peek()) {
                min.poll();
                min.add(num);
            }
        }
        return min.peek();
    }

}
