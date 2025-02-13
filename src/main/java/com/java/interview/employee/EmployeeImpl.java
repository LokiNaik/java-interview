package com.java.interview.employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeImpl {

    public static void main(String[] args) {
        List<Employee> employees = Employee.getEmployees();

//        findMaleAndFemale(employees);
//        findMaleAndFemaleCountUsingStreams(employees);
//        printDepartments(employees);
//        averageAge(employees);
//        highestSalary(employees);
//        lowestSalary(employees);
        getEmployeesSalary(employees);
        countEmployeesInEachDept(employees);
        printEmployeesNamesInSingleString(employees);
        findAvgSalaryInEachDept(employees);
        findSecondHighestSalary(employees);
    }

    //  * 1. How many male and female employees are there in the organization?

    // traditional way.
    public static void findMaleAndFemale(List<Employee> employees) {
        int maleCount = 0;
        int femaleCount = 0;
        for (Employee employee : employees) {
            if (employee.getGender() == "Male") {
                maleCount++;
            } else if (employee.getGender() == "Female") {
                femaleCount++;
            }
        }
        System.out.println("Male: " + maleCount);
        System.out.println("Female: " + femaleCount);
    }

    public static void findMaleAndFemaleCountUsingStreams(List<Employee> employees) {
        Map<String, Long> count = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(count);
    }

    //  Print the name of all departments in the organization?
    public static void printDepartments(List<Employee> employees) {
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
    }

    // What is the average age of male and female employees?
    public static void averageAge(List<Employee> employees) {
        employees.stream()
                .mapToDouble(Employee::getSalary)  // Extract salaries (convert Employee objects to double values)
                .average() // Calculate the average
                .ifPresent(System.out::println);
    }

    /*Find the employee with the highest salary*/
    public static void highestSalary(List<Employee> employees) {
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);
    }

    public static void lowestSalary(List<Employee> employees) {
        employees.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);
    }

    /* 2. Get a List of Employees Earning More Than 50,000*/
    public static void getEmployeesSalary(List<Employee> employees) {
        employees.stream().filter(salary -> salary.getSalary() < 50000).forEach(System.out::println);
    }

    /*. Count the Number of Employees in Each Department*/
    public static void countEmployeesInEachDept(List<Employee> employees) {
        Map<String, Long> empDept = employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment,
                                Collectors.counting()));
        System.out.println(empDept);
    }

    /* Get the Names of All Employees in a Single String */
    public static void printEmployeesNamesInSingleString(List<Employee> employees) {
        String em = employees
                .stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(em);
    }

    /*Find the Average Salary of Employees in Each Department*/
    public static void findAvgSalaryInEachDept(List<Employee> employees) {
        Map<String, Double> emp = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(emp);
    }

    /*Find the Second-Highest Salary*/
    public static void findSecondHighestSalary(List<Employee> employees) {
       Optional<Employee> secondHighestSalary =  employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
        System.out.println(secondHighestSalary);
    }

}
