# Answers

### 1
The key differences between primitive data types and objects in Java are...

  #### Primitive Data types:
  - These are the most basic data types in Java and represent simple values. Examples include int, char, boolean, float, etc.
  - They are stored directly in memory with their actual values. Each primitive type has a fixed size (e.g., int is 4 bytes).
  - Faster because they store the raw values direclty.
  - Primitive types are immutable.
  #### Objects
  - Objects are instances of classes, which can store data and have methods to operate on that data. Objects are more complex and are used to represent real-world entities.
  - An object is stored as a reference (or memory address) to the location where the data (fields) is held in memory. This reference points to an instance of a class in the heap.
  - Objects are slow because they involve in more complex operations.
  - Objects are mutable they can be changed based on the class.

### question2
- The 'static' keyword in Java is used for memory management. Memory is allocated only once during the execution of the program.
- Static key word belongs to the class rather than instance of a class.
- The static keyword is a non-access modifier, can use static keyword for methods, variables, blocks and nested classes.
- Static methods can be overloaded but not over-ridden. we can have multiple methods with different parameters.
- Static variables are, essentially, global variables.

### 3
- Static method is tied to class itself and not with the objects. So when we call a static method we call it from class and not using the Object.
- Over-loading is like having multiple methods with different parameters. overloading is a compile time polymorphism.

### 4
  ##### Method overloading
  - It is a compile time polymorphism.
  - It increases the readability of the program.
  - It occurs with in the class.
  - Same method name but different parameters, data types and number of parameters.
  - Return type may be same but the parameters should be changed.
  - Private and Final methods can be overloaded.
  #### Method Over riding.
  - It is a run time polymorphism
  - It is used to grant the specific implementation of the method which is already provided by its parent or super class.
  - It happens in two different class with inheritance relationship.
  - It always need inheritances.
  - Require same method name and signature inorder to be overridden.
  - Return type should be same.
  - Private and Final methods are not overridden.

### 5
- == compares object reference (memory address) and .equal() compares the content of the string. we always use .equals() for string.
- Example
  String str1 = "Hello";
  String str2 = "Hello";
  String str3 = new String("Hello");
  System.out.println(str1 == str2);       // true (same object reference)
  System.out.println(str1 == str3);       // false (different object references)
  System.out.println(str1.equals(str2));  // true (same content)
  System.out.println(str1.equals(str3));  // true (same content)

