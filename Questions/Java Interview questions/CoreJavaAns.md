# Core Java and Spring Interview Questions

This document provides detailed answers to frequently asked Java and Spring interview questions.

---

# String Class in Java

## Why is String immutable?
String is immutable in Java due to the following reasons:

1. **Security** – Strings are often used to store sensitive data like usernames and passwords. If a string were mutable, an attacker could modify its contents, causing security vulnerabilities.
2. **String Pool Optimization** – Java maintains a **String Pool** in heap memory. When a new string is created using a string literal, Java first checks if the same value exists in the pool. If it does, it reuses the reference instead of creating a new object. If strings were mutable, modifying one reference would affect all others, breaking this optimization.
3. **Thread-Safety** – Immutable objects are inherently thread-safe because their values cannot change. This makes strings safe to use across multiple threads without additional synchronization.
4. **HashCode Caching** – Strings cache their hash code after the first computation. This allows them to be efficiently used as keys in hash-based collections like `HashMap`.

### Example:
```java
String s1 = "Hello";
String s2 = "Hello";
System.out.println(s1 == s2); // true (both refer to the same object)

s1 = s1 + " World";
System.out.println(s1 == s2); // false (new object created)
```

---

## Difference Between StringBuffer and StringBuilder
| Feature        | StringBuffer | StringBuilder |
|---------------|-------------|--------------|
| Synchronization | Yes (Thread-safe) | No (Not thread-safe) |
| Performance | Slower due to synchronization | Faster due to no synchronization |
| Use Case | Use in multi-threaded applications | Use in single-threaded applications |

### Example:
```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
System.out.println(sb); // Output: Hello World
```

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb); // Output: Hello World
```

---

## String Pool in Java
The **String Pool** is a special memory area inside the heap where Java stores string literals to optimize memory usage.

### Example:
```java
String s1 = "Hello";
String s2 = "Hello";
System.out.println(s1 == s2); // true (same reference due to string pool)

String s3 = new String("Hello");
System.out.println(s1 == s3); // false (new object created in heap)
```

---

## How to Make a Mutable String in Java?
You can use `StringBuffer` or `StringBuilder` to create a mutable string.

### Example:
```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
System.out.println(sb); // Output: Hello World
```

```java
StringBuilder sb = new StringBuilder("Java");
sb.replace(0, 4, "Python");
System.out.println(sb); // Output: Python
```

---

This file covers detailed explanations about Strings in Java, including immutability, differences between `StringBuffer` and `StringBuilder`, and the String Pool. Let me know if you need more topics!

# Basic Java

## Memory Management in Java
Java memory is divided into five areas:
1. **Method Area** – Stores class structure, method code, and static variables.
2. **Heap** – Stores objects and instance variables.
3. **Stack** – Stores method calls and local variables.
4. **PC Register** – Stores the address of the current instruction.
5. **Native Method Stack** – Stores native method calls.

### Example:
```java
class Demo {
    int x = 10; // Stored in Heap
    static int y = 20; // Stored in Method Area

    void display() {
        int z = 30; // Stored in Stack
        System.out.println(x + y + z);
    }
}
```


### Which memory areas among Method, HEAP, Stack, PC register, Natve Method stacks are thread safe?
- In Java, thread safety refers to the ability of a memory area or resource to be safely accessed by multiple threads concurrently without causing data inconsistency or corruption. Let’s examine each memory area to understand whether it is thread-safe or not:

- **1. Method Area**
    - The Method Area (often part of the Permanent Generation or Metaspace) stores class-level data such as the class structures, methods, static variables, and constant pools.
    - Thread-Safety: The Method Area itself is not thread-safe in the sense that multiple threads can access the class definitions concurrently.
However, the JVM ensures synchronization mechanisms are in place when reading and writing class metadata to prevent inconsistency (like class loading or unloading).
    - Class loading and unloading are synchronized, so there’s no risk of corruption, but it's still shared across threads.
- **2. Heap**
   - The Heap is where objects are dynamically allocated during runtime. Objects are stored here, and it's used by all threads.
   - Thread-Safety:
       - The Heap is not thread-safe by default. Multiple threads can access objects stored in the Heap simultaneously, which may lead to race conditions, such as when multiple threads are trying to modify the same object.
       - Thread safety in the Heap can be ensured by using synchronization techniques like synchronized blocks, locks, or atomic operations for shared mutable objects.
- **3. Stack**
    - The Stack is used by each thread to store method frames, local variables, and the call stack. Each thread has its own private stack.
    - Thread-Safety:
        - The Stack is thread-safe because each thread has its own local stack. Therefore, each thread’s stack is independent of the others, and there is no sharing of stack data between threads.
        - Since each thread operates on its own stack, there's no interference or race condition between threads accessing their own stack data.
- **4. Program Counter (PC) Register**
    - The Program Counter (PC) Register keeps track of the current instruction being executed by each thread. Each thread has its own PC register.
    - Thread-Safety:
        - The PC register is thread-safe because each thread has its own PC register.
Since the PC register is part of the thread context, and each thread operates independently, there is no sharing or conflict over the PC register between threads.
- **5. Native Method Stack**
    - The Native Method Stack is used for native method calls (methods written in languages like C or C++ that are executed outside the JVM).
    - Thread-Safety:
        - The Native Method Stack is thread-safe in the sense that each thread has its own native stack when calling native methods.
        - Each thread’s native stack is independent of others, so there’s no conflict or race condition between threads.
--- 

| Memory Area	| Thread-Safe?	| Explanation |
| -- | ---|---|
| Method Area	| Not thread-safe	| Class-level data and metadata are shared across threads, though access is synchronized. |
| Heap | Not thread-safe	| Objects in the Heap can be accessed and modified by multiple threads simultaneously, requiring synchronization. |
| Stack	| Thread-safe	| Each thread has its own stack, so no interference occurs between threads. |
| Program Counter (PC)	| Thread-safe	| Each thread has its own PC register, so there's no sharing or conflict. |
| Native Method Stack	| Thread-safe	| Each thread has its own native method stack, so no sharing occurs. |

---

## Loader Subsystem
The ClassLoader subsystem loads classes into memory. It consists of:
- **Bootstrap ClassLoader** – Loads core Java classes (e.g., `java.lang` package).
- **Extension ClassLoader** – Loads classes from `lib/ext`.
- **Application ClassLoader** – Loads application-specific classes.

### Example:
```java
ClassLoader classLoader = Demo.class.getClassLoader();
System.out.println(classLoader); // Output: Application ClassLoader
```

---

## Garbage Collection in Java
Garbage Collection (GC) is the process of reclaiming unused memory.

### Types of GC Algorithms:
- **Serial GC** – Uses a single thread to perform GC.
- **Parallel GC** – Uses multiple threads to speed up GC.
- **CMS GC** – Performs GC without stopping the application.
- **G1 GC** – Splits memory into regions and collects garbage incrementally.

### Example:
```java
class TestGC {
    protected void finalize() {
        System.out.println("Garbage Collected!");
    }
    public static void main(String[] args) {
        TestGC t1 = new TestGC();
        t1 = null; // Eligible for GC
        System.gc(); // Suggest GC
    }
}
```

---

## Memory Leak in Java
A memory leak occurs when objects are not garbage collected due to lingering references.

### Causes of Memory Leaks:
- Holding unnecessary references to objects.
- Not closing resources like database connections, file streams.

### How to Handle:
- Use **weak references**.
- Close resources properly using try-with-resources.

### Example:
```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
} // Automatically closes resources
```

---

## SOLID Principles
1. **Single Responsibility Principle** – A class should have one responsibility.
2. **Open/Closed Principle** – A class should be open for extension but closed for modification.
3. **Liskov Substitution Principle** – Subclasses should be replaceable for parent classes.
4. **Interface Segregation Principle** – Avoid forcing classes to implement unused methods.
5. **Dependency Inversion Principle** – High-level modules should depend on abstractions, not concrete implementations.

### Example:
```java
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Bark");
    }
}
```

---

## AutoCloseable Interface
`AutoCloseable` allows automatic resource management using try-with-resources.

### Example:
```java
class Resource implements AutoCloseable {
    public void use() {
        System.out.println("Using Resource");
    }
    public void close() {
        System.out.println("Resource Closed");
    }
}

public class Main {
    public static void main(String[] args) {
        try (Resource r = new Resource()) {
            r.use();
        }
    }
} // Output: Using Resource \n Resource Closed
```

---

## Difference between Web Server and Application Server
- **Web Server** – Handles HTTP requests and responses (e.g., Apache, Nginx, Tomcat).
- **Application Server** – Provides an environment for running applications (e.g., JBoss, WebLogic, GlassFish).

---

## Java Features
1. **Platform Independent** – Java code runs on any platform via JVM.
2. **Object-Oriented** – Uses classes and objects.
3. **Secure** – Provides runtime security features.
4. **Robust** – Manages memory automatically.
5. **Multi-threaded** – Supports concurrent execution.
6. **High Performance** – Uses Just-In-Time (JIT) compiler.

---

## Volatile Keyword
`volatile` ensures that a variable is always read from main memory instead of CPU cache, ensuring visibility across threads.

### Example:
```java
class VolatileExample {
    private volatile boolean flag = true;
    public void run() {
        while (flag) {
            // Loop runs until flag changes
        }
    }
}
```

---

## What is a Constructor?
A constructor is a special method used to initialize objects.

### Example:
```java
class Car {
    String model;
    Car(String model) {
        this.model = model;
    }
}
```

---

## Increment and Decrement Operators
- `++var` (Pre-increment) – Increments before using value.
- `var++` (Post-increment) – Increments after using value.

### Example:
```java
int x = 5;
System.out.println(++x); // Output: 6
System.out.println(x++); // Output: 6
```

---

## Wrapper Classes
Wrapper classes convert primitive types into objects (`Integer`, `Double`, `Boolean`, etc.).

### Example:
```java
int num = 10;
Integer obj = Integer.valueOf(num);
System.out.println(obj); // Output: 10


# Exception Handling in Java

## What is an Exception?
An exception is an unexpected event that occurs during program execution, disrupting the normal flow of instructions. Java provides exception-handling mechanisms to handle runtime errors.

## Exception Hierarchy
Java exceptions are part of a hierarchical structure:
- **Throwable (Superclass)**
  - **Exception** (Recoverable errors)
    - Checked Exceptions (Must be handled using try-catch or declared using throws)
    - Unchecked Exceptions (Runtime exceptions that don’t need explicit handling)
  - **Error** (Non-recoverable system-level failures)

## Throwable Class
`Throwable` is the parent class for both `Exception` and `Error`.

```java
public class ThrowableExample {
    public static void main(String[] args) {
        try {
            throw new Exception("Custom Exception");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
```

## Checked vs Unchecked Exceptions

### Checked Exceptions
These exceptions must be explicitly handled using try-catch or declared using `throws`.
Examples: `IOException`, `SQLException`

```java
import java.io.*;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("non_existing_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
```

### Unchecked Exceptions
These exceptions occur at runtime and do not require explicit handling.
Examples: `NullPointerException`, `ArrayIndexOutOfBoundsException`

```java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr[10]); // Throws ArrayIndexOutOfBoundsException
    }
}
```

## Difference Between Exception and Error
| Feature | Exception | Error |
|---------|----------|-------|
| Recoverable? | Yes | No |
| Occurrence | Due to application issues | Due to system issues |
| Examples | IOException, NullPointerException | OutOfMemoryError, StackOverflowError |

## Multiple Catch Blocks
Multiple `catch` blocks can be used to handle different exception types.

```java
public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception caught");
        } catch (Exception e) {
            System.out.println("General Exception caught");
        }
    }
}
```

## Try-Catch-Finally
`finally` block always executes, ensuring resource cleanup.

```java
public class FinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
        } catch (Exception e) {
            System.out.println("Exception caught");
        } finally {
            System.out.println("Finally block executed");
        }
    }
}
```

## Difference Between `throw` and `throws`
| Keyword | Purpose |
|---------|---------|
| `throw` | Used to explicitly throw an exception |
| `throws` | Declares exceptions that a method may throw |

```java
public class ThrowExample {
    static void validate(int age) {
        if (age < 18)
            throw new IllegalArgumentException("Not eligible to vote");
    }
    public static void main(String[] args) {
        validate(16);
    }
}
```

## Common Exceptions
- **NullPointerException** – Occurs when accessing a null object.
- **ArrayIndexOutOfBoundsException** – Accessing array elements beyond valid indices.
- **ClassCastException** – Invalid typecasting between unrelated classes.

```java
public class ClassCastExceptionExample {
    public static void main(String[] args) {
        Object obj = new String("Hello");
        Integer num = (Integer) obj; // Throws ClassCastException
    }
}
```

## Overriding Exception Handling
When overriding methods, you cannot throw new checked exceptions that were not declared in the parent method.

```java
class Parent {
    void display() throws IOException {
        System.out.println("Parent Method");
    }
}

class Child extends Parent {
    void display() throws FileNotFoundException { // Allowed (Subclass of IOException)
        System.out.println("Child Method");
    }
}
```

This document provides a detailed explanation of Java exception handling with examples. Let me know if any topic needs more depth!


# Serialization in Java

## What is Serialization and Deserialization?
Serialization is the process of converting an object into a byte stream so that it can be stored in a file, transmitted over a network, or persisted in a database. Deserialization is the reverse process, where the byte stream is converted back into an object.

### Why use Serialization?
- To persist objects to files or databases.
- To transfer objects over a network.
- To cache objects in memory.

### How to Implement Serialization?
In Java, an object can be serialized by implementing the `java.io.Serializable` interface.

#### Example:
```java
import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        Person person = new Person("John", 25);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Object Serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## How to Deserialize an Object?
```java
public class DeserializationDemo {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person person = (Person) ois.readObject();
            System.out.println("Deserialized Person: " + person.name + ", " + person.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

---

## What is Transient Keyword?
The `transient` keyword prevents a variable from being serialized. When an object is serialized, transient variables are ignored.

#### Example:
```java
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    transient int salary; // Will not be serialized

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
```

---

## What is Externalization?
`Externalizable` is an interface that provides complete control over serialization by overriding two methods:
1. `writeExternal(ObjectOutput out)`: Defines how to serialize an object.
2. `readExternal(ObjectInput in)`: Defines how to deserialize an object.

#### Example:
```java
import java.io.*;

class Student implements Externalizable {
    String name;
    int age;

    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }
}
```

---

## What is SerialVersionUID?
`serialVersionUID` is a unique identifier used during deserialization to verify that a serialized object and its class definition are compatible.

If a class is modified after serialization without updating the `serialVersionUID`, a `InvalidClassException` will be thrown during deserialization.

#### Example:
```java
class Example implements Serializable {
    private static final long serialVersionUID = 123456789L;
    String data;
}


# Object Class in Java

## What is hashCode()?
`hashCode()` is a method in the `Object` class that returns an integer hash code representing an object's memory address (by default) or a computed hash value.

### Example:
```java
class HashCodeExample {
    int id;
    HashCodeExample(int id) {
        this.id = id;
    }
    public static void main(String[] args) {
        HashCodeExample obj1 = new HashCodeExample(1);
        HashCodeExample obj2 = new HashCodeExample(1);
        System.out.println(obj1.hashCode()); // Prints hash value
        System.out.println(obj2.hashCode()); // Different hash value
    }
}
```

## Why is hashCode printed in console?
When an object is printed, its `toString()` method is called, which by default returns:
```
ClassName@hashCodeInHex
```

### Example:
```java
class Demo {}
public class Main {
    public static void main(String[] args) {
        Demo obj = new Demo();
        System.out.println(obj); // Output: Demo@someHashCode
    }
}
```

## How to get data from a hashCode?
Hash code itself does not store or retrieve data. However, it's used in collections like `HashMap` for fast lookups.

## Methods in Object Class

### 1. `hashCode()`
Returns an integer hash code for an object.

### 2. `clone()`
Creates a shallow copy of an object. Requires implementing `Cloneable`.

#### Example:
```java
class Person implements Cloneable {
    String name;
    Person(String name) {
        this.name = name;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("John");
        Person p2 = (Person) p1.clone();
        System.out.println(p2.name); // Output: John
    }
}
```

### 3. `wait()`, `notify()`, `notifyAll()`
Used for inter-thread communication.

#### Example:
```java
class Shared {
    synchronized void waitMethod() {
        try {
            System.out.println("Waiting...");
            wait();
            System.out.println("Resumed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void notifyMethod() {
        System.out.println("Notifying...");
        notify();
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        Shared obj = new Shared();
        new Thread(obj::waitMethod).start();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        new Thread(obj::notifyMethod).start();
    }
}
```

### 4. `finalize()`
Called before an object is garbage collected.

#### Example:
```java
class FinalizeExample {
    protected void finalize() {
        System.out.println("Object is being garbage collected");
    }
    public static void main(String[] args) {
        FinalizeExample obj = new FinalizeExample();
        obj = null;
        System.gc(); // Requesting GC
    }
}
```

### 5. `getClass()`
Returns the runtime class of an object.

#### Example:
```java
class Demo {}
public class Main {
    public static void main(String[] args) {
        Demo obj = new Demo();
        System.out.println(obj.getClass().getName()); // Output: Demo
    }
}


# OOP Concepts in Java

## 1. Encapsulation
Encapsulation is the technique of wrapping data (variables) and code (methods) together as a single unit. It restricts direct access to some of an object's components and ensures controlled data manipulation.

### Example:
```java
class Person {
    private String name;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
```

## 2. Inheritance
Inheritance allows a class to acquire properties and behavior from another class.

### Example:
```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}
```

## 3. Polymorphism
Polymorphism allows objects to be treated as instances of their parent class.

### Example:
```java
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a circle");
    }
}
```

## 4. Abstraction
Abstraction hides implementation details and only exposes the necessary parts.

### Example:
```java
abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car is starting");
    }
}
