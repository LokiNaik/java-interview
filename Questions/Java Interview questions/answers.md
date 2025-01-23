# Answers

### 1. Key Differences Between Primitive Data Types and Objects in Java

#### Primitive Data Types:
- These are the most basic data types in Java and represent simple values. Examples include `int`, `char`, `boolean`, `float`, etc.
- They are stored directly in memory with their actual values. Each primitive type has a fixed size (e.g., `int` is 4 bytes).
- Faster because they store the raw values directly.
- Primitive types are immutable.

#### Objects:
- Objects are instances of classes, which can store data and have methods to operate on that data. Objects are more complex and are used to represent real-world entities.
- An object is stored as a reference (or memory address) to the location where the data (fields) is held in memory. This reference points to an instance of a class in the heap.
- Objects are slower because they involve more complex operations.
- Objects are mutable—they can be changed based on the class.

### 2. The `static` Keyword in Java

- The `static` keyword in Java is used for memory management. Memory is allocated only once during the execution of the program.
- The `static` keyword belongs to the class rather than an instance of the class.
- The `static` keyword is a non-access modifier; you can use `static` for methods, variables, blocks, and nested classes.
- Static methods can be overloaded but not overridden. We can have multiple methods with different parameters.
- Static variables are essentially global variables.

### 3. Static Methods and Overloading

- A static method is tied to the class itself, not to objects. So, when we call a static method, we call it from the class and not using an object.
- Overloading is like having multiple methods with different parameters. Overloading is a compile-time polymorphism.

### 4. Method Overloading vs. Method Overriding

#### Method Overloading:
- It is compile-time polymorphism.
- It increases the readability of the program.
- It occurs within the class.
- Same method name but different parameters, data types, and number of parameters.
- The return type may be the same, but the parameters should be changed.
- Private and final methods can be overloaded.

#### Method Overriding:
- It is runtime polymorphism.
- It is used to grant the specific implementation of a method that is already provided by its parent or superclass.
- It happens in two different classes with an inheritance relationship.
- Inheritance is always required.
- Requires the same method name and signature in order to be overridden.
- The return type should be the same.
- Private and final methods cannot be overridden.

### 5. Comparison of `==` and `.equals()` for Strings

- `==` compares the object reference (memory address), and `.equals()` compares the content of the string. We always use `.equals()` for strings.

- Example:

  ```java
  String str1 = "Hello";
  String str2 = "Hello";
  String str3 = new String("Hello");

  System.out.println(str1 == str2);       // true (same object reference)
  System.out.println(str1 == str3);       // false (different object references)
  System.out.println(str1.equals(str2));  // true (same content)
  System.out.println(str1.equals(str3));  // true (same content)
