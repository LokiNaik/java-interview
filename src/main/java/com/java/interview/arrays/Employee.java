package com.java.interview.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
    private String id;
    private String name;
    private String dept;
    private int salary;

    public Employee(String id, String name, String dept, int salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

class EmployeeImple{
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "lokesh","IT",10000));
        employeeList.add(new Employee("2", "suresh", "IT", 15000));
        employeeList.add(new Employee("3", "lakshmi","HR", 10000));

//       Map<Integer, Long> res = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept), Collectors.averagingInt(Employee::getSalary));
    }
}
