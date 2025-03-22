package com.java.interview.java8.streams;

import java.util.Arrays;

/**
 * Filter is used to apply some condition on the expression.
 * It acts as a gate only the once that satisfied the condition will be allowed further.
 */
public class FilterExample {

    public static void main(String[] args) {
        /* Here in this we will print only even numbers using filter */
        int[] wholeNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       Arrays.stream(wholeNumbers).filter(number -> number % 2 == 0).forEach(System.out::println);
    }
}
