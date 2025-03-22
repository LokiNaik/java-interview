package com.java.interview.java8.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertArraytoStream {

    public static void main(String[] args) {
        Integer[] objectArray = {1,2,5,6};
        int[] primitiveDataArray = {1,2,3,4};

        Stream<Integer> stream = Arrays.stream(objectArray);
        stream.forEach(System.out::println);

        IntStream intStream = Arrays.stream(primitiveDataArray);
        intStream.forEach(System.out::println);
    }
}
