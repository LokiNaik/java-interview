package com.java.interview.serialization;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person("Lokesh Naik", 26);

        // serialization..
        try {
            ObjectOutputStream oom = new ObjectOutputStream(new FileOutputStream("testFile.txt"));
            oom.writeObject(person);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Person object is serialized");
        }

        deSerilization();

    }

    public static void deSerilization() {
        // deserialization
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("testFile.txt"));
            Person p = (Person) objectInputStream.readObject();
            System.out.println(p.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}