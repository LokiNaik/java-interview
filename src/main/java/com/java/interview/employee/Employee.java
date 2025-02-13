package com.java.interview.employee;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private double salary;
    private String dateOfJoining;

    public Employee(int id, String name, int age, String gender, String department, double salary, String dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                '}';
    }

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "John Doe", 28, "Male", "IT", 60000, "2022-05-12"));
        employees.add(new Employee(102, "Jane Smith", 32, "Female", "HR", 55000, "2020-08-15"));
        employees.add(new Employee(103, "Michael Johnson", 45, "Male", "Finance", 75000, "2015-03-10"));
        employees.add(new Employee(104, "Sarah Davis", 25, "Female", "Marketing", 48000, "2023-01-01"));
        employees.add(new Employee(105, "David Williams", 38, "Male", "Operations", 67000, "2017-11-05"));
        employees.add(new Employee(106, "Emily Evans", 40, "Female", "IT", 72000, "2018-06-25"));
        employees.add(new Employee(107, "Matthew Brown", 30, "Male", "Finance", 68000, "2021-10-14"));
        employees.add(new Employee(108, "Olivia Garcia", 27, "Female", "HR", 54000, "2022-02-20"));
        employees.add(new Employee(109, "Daniel Martinez", 35, "Male", "Marketing", 62000, "2019-09-12"));
        employees.add(new Employee(110, "Sophia Rodriguez", 29, "Female", "Sales", 55000, "2020-11-22"));
        employees.add(new Employee(111, "James Lee", 26, "Male", "Operations", 49000, "2023-01-05"));
        employees.add(new Employee(112, "Charlotte Harris", 33, "Female", "Finance", 70000, "2016-03-18"));
        employees.add(new Employee(113, "Liam Walker", 28, "Male", "HR", 53000, "2021-07-30"));
        employees.add(new Employee(114, "Ava Young", 31, "Female", "IT", 65000, "2022-09-01"));
        employees.add(new Employee(115, "Ethan King", 43, "Male", "Marketing", 78000, "2014-02-10"));
        employees.add(new Employee(116, "Isabella Scott", 36, "Female", "Operations", 56000, "2017-04-07"));
        employees.add(new Employee(117, "Lucas Allen", 25, "Male", "Sales", 47000, "2023-03-21"));
        employees.add(new Employee(118, "Mia Carter", 30, "Female", "Finance", 64000, "2019-12-02"));
        employees.add(new Employee(119, "Jackson Moore", 34, "Male", "Marketing", 69000, "2016-07-15"));
        employees.add(new Employee(120, "Amelia Taylor", 29, "Female", "IT", 72000, "2021-04-23"));

        return employees;
    }


}
