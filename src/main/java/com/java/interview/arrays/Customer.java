package com.java.interview.arrays;

public class Customer {

    private final int max = 30;
    private String name;

    public Customer(String name){
        this.name = name;

    }

//    public static void printMax(){
//        Customer customer = new Customer();
//        System.out.println(customer.max);
//    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("lokesh");
        Customer customer2 = new Customer("lokesh");
        System.out.println(customer1.equals(customer2));
        System.out.println(customer1==customer2);
    }
}

//class Emplopyee {
//    sures 15000, IT
//    lokesh 10000 it
//    laxmi 10000 hr
//}
//employee (String id,str name, Str dept, int sal )
//    List<Emp>  list
//
//            highest sal emp in dept



