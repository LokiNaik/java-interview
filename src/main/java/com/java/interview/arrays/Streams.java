package com.java.interview.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 1️⃣ Intermediate Operations (Transformations)
 * (These return a Stream and are lazy)
 * <p>
 * Method	Description
 * filter(Predicate<T>)	Filters elements based on a condition
 * map(Function<T,R>)	Transforms elements
 * flatMap(Function<T,Stream<R>>)	Flattens a Stream of Streams
 * distinct()	Removes duplicates
 * sorted()	Sorts elements
 * peek(Consumer<T>)	Debugging (like forEach but doesn’t terminate)
 * limit(n)	Limits the number of elements
 * skip(n)	Skips first n elements
 */
public class Streams {

    public static final Logger logger = LoggerFactory.getLogger(Streams.class);

    /**
     * Iterator Basic example.
     * Prints multiples of 2 up to 20.
     */
    public static void iteratorExamples() {
        logger.info("Prints the numbers upto 20 with multiply by 2");
        Stream<Integer> stream = Stream.iterate(1, i -> i <= 20, i -> i * 2);
        stream.forEach(System.out::println);
    }

    /**
     * Iterate to generate upto max integer provided.
     */
    public static void iterateExamples() {
        logger.info("Printing the numbers upto limit of 5");
        Stream<Integer> stream = Stream.iterate(1, n -> n + 1).limit(5);
        stream.forEach(System.out::println);
    }

    /**
     *  Generates random numbers.
     */
    public static void generateRandomNumbers() {
        logger.info("Prints the random numbers upto 10");
        Stream<Double> integerStream = Stream.generate(Math::random).limit(10);
        integerStream.forEach(System.out::println);
    }

    /** This method filters the array as per the given requirement.*/
    public static void filterMethodExample() {
        logger.info("Filter method example");
        List<String> namesList = Arrays.asList("Lokesh", "Devika", "Naik");
        namesList.stream().filter(names -> names.length() > 4).map(String::toUpperCase).forEach(System.out::println);
        List<String> namesList2 = namesList.stream().filter(names -> names.length() >= 4).map(names -> names.toUpperCase()).toList();
        namesList2.stream().forEach(System.out::println);
    }

    /**
     * Basic example for Lambda expression, print the cube using the Lambda expression
     *
     * syntax ==> (params) -> {body};
     */
    public static void exampleForLambdaExpression(int number) {
        /*Print a cube of number*/
        logger.info("Printing cube of given number: {}",  number);
        Function<Integer, Integer> cube = x -> x * x * x;
        System.out.println("Cube of "+ number + " is : " +cube.apply(number)); // prints cube.
    }

    /**
     * This distinct() is used to return only unique elements from the array.
     *
     * @param list
     * @return
     */
    public static Stream<String> distinctMethodExample(List<String> list) {
        logger.info("Inside distinctMethodExample which prints only unique values from given array.");
        return list.stream().distinct();
    }

    public static Stream<?> sortedMethodExample(List<?> list) {
        return list.stream().sorted();
    }

    public static void reduceMethodExample(List<Integer> list) {
        int sum = list.stream().reduce(0, (element1, element2) -> element1 + element2);
        System.out.println(sum);
    }

    public static void getTheLongestString(List<String> list) {
        Optional<String> longestString = list.stream().reduce((element1, element2) -> element1.length() > element2.length() ? element1 : element2);
        longestString.ifPresent(System.out::println);
    }

    public static void longestStringExample(List<String> list) {
        Optional<String> longest = list.stream().max(Comparator.comparingInt(String::length));
        longest.ifPresent(s1 -> System.out.println(s1));
    }

    /*Reverse each string in a list*/
    public static void reverseEachString(List<String> list) {
        list.stream().map(s -> new StringBuilder(s).reverse().toString()).forEach(System.out::println);
    }

    /*Palindrome string using streams*/
    public static void isPalindrome(List<String> list) {
        list.stream().map(s -> s.equals(new StringBuilder(s).reverse().toString())).forEach(System.out::println);
    }


    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("Lokesh", "Devika", "Lokesh Naik", "naik", "Lokesh");
        /*Longest string*/
        longestStringExample(namesList);

        /*Reverse each string*/
        reverseEachString(namesList);

        /*Palindrome using string*/
        isPalindrome(namesList);

        iterateExamples();

        iteratorExamples();

        exampleForLambdaExpression(3);


//        generateRandomNumbers();
//        filterMethodExample();

//        /* distinct method */
        Stream<String> stream = distinctMethodExample(namesList);
        stream.forEach(System.out::println);


        /** Sorted method **/
//        Stream<String> sortedStream = (Stream<String>) sortedMethodExample(namesList);
//        sortedStream.forEach(System.out::println);

        /* reduce method */
//        reduceMethodExample(Arrays.asList(1, 2, 3, 4, 5));

        /*LongestString*/
        getTheLongestString(Arrays.asList("Lokesh", "Devika", "Lokesh Naik", "naik", ""));
    }


}
