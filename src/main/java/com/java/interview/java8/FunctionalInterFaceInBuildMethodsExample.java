package com.java.interview.java8;

import java.util.Date;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java SE 8 included four main kinds of functional interfaces which can be applied in multiple situations as mentioned below:
 * 1. Consumer
 * 2. Predicate
 * 3. Function
 * 4. Supplier
 */
public class FunctionalInterFaceInBuildMethodsExample {
    public static void main(String[] args) {
        modifyingPersonObjectExample();
    }

    /**
     * Example of Consumer Interface.
     * Here it only consumes the input but doesn't return any values.
     * This is used for Logging, Printing, or Modifying objects.
     * <p>
     * This example is for sending a notification to user.
     */
    public static void printPersonUsingConsume(Person message) {
        Consumer<Person> notification = p -> System.out.println("Modified Person : " + p);
        notification.accept(message);
    }

    public static void modifyingPersonObjectExample() {
        Consumer<Person> modifiedPerson = person -> {
            person.setAge(25);
            person.setName("Lokesh");
        };
        Person person = new Person();
        modifiedPerson.accept(person);

        // calling Predicate from here to check if person is valid.
        predicateExample(person);

        // calling Supplier to add the password and created date
        Person p = supplierExample(person);

        // calling functionExample method to convert the Salary from USD to INR.
        functionExample(p);

        // calling method to print the person.
        printPersonUsingConsume(p);
    }

    /**
     * Predicate<T> This is used to return boolean value based on the condition.
     */
    public static void predicateExample(Person person) {
        Predicate<Person> personPredicate = p -> p.getAge() > 25 && p.getName().length() > 5 || p.getName().equals("Lokesh");
        System.out.println("Person predicate: " + personPredicate.test(person));
    }

    /**
     * This is Supplier<T> which doesn't need any input but provides the output.
     * Used for generating OTPs, TimeStamps.
     */
    public static Person supplierExample(Person person) {
        Supplier<Person> supplier = () -> {
            person.setSalary(10000.0);
            person.setCreatedDate(new Date());
            person.setPassword((UUID.randomUUID().toString()));
            return person;
        };
        return supplier.get();
    }

    /**
     * This Function<T,R> used to accept the T param and return R type.
     * this is used to convert from one type to another.
     *
     * @param person Person
     */
    public static void functionExample(Person person) {
        Function<Double, Double> function = usd -> usd * 83; // converting USD to INR.
        Double salaryInINR = function.apply(person.getSalary());
        person.setSalary(salaryInINR);
    }


}

