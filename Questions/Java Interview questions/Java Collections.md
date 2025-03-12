# Collection Hierarchy
  The java.util package contains all the collection classes and interfaces.

## Collection Interface (Root Interface)
 ### List (Ordered, allows duplicates)
    - ArrayList
    - LinkedList
    - Vector (Thread-safe)
    - Stack
  ### Set (Unordered, no duplicates)
    - HashSet
    - LinkedHashSet
    - TreeSet
  ### Queue (FIFO ordering)
    - PriorityQueue
    - Deque (Double-ended queue)
    - ArrayDeque
  ### Map (Key-Value pair, No duplicate keys)
    - HashMap
    - LinkedHashMap
    - TreeMap
    - Hashtable (Thread-safe)
    - ConcurrentHashMap (Thread-safe)


--------------------
**Java Collections Internal Working**

## **1. List Interface Implementations**

### **(a) ArrayList (Dynamic Array)**
#### **Internal Working**
- **Data Structure**: Uses a dynamic array (Object[]).
- **Initial Capacity**: Default is **10**.
- **Resizing Mechanism**:
  - When the array reaches full capacity, a new array is created with **1.5 times** the previous capacity.
  - The old elements are copied to the new array.
- **Performance**:
  - **Insertion**: `O(1)` (Amortized) for adding at the end; `O(n)` for inserting in between.
  - **Search**: `O(1)` for index-based access.
  - **Deletion**: `O(n)` (Shifting elements).

### **Example**
```java
List<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
list.add(1, 15);
System.out.println(list); // Output: [10, 15, 20]
```

---

### **(b) LinkedList (Doubly Linked List)**
#### **Internal Working**
- **Data Structure**: Doubly Linked List.
- **Each Node Contains**: `data`, `prev` (pointer to previous node), `next` (pointer to next node).
- **Performance**:
  - **Insertion/Deletion**: `O(1)` (If pointer to node is known).
  - **Search**: `O(n)` (Sequential search required).

### **Example**
```java
LinkedList<String> list = new LinkedList<>();
list.add("A");
list.addFirst("B");
list.addLast("C");
System.out.println(list); // Output: [B, A, C]
```

---

## **2. Set Interface Implementations**

### **(a) HashSet (Uses HashMap Internally)**
#### **Internal Working**
- **Data Structure**: Uses **HashMap** internally.
- **Insertion Mechanism**:
  - Calls `hashCode()` on the object to find the bucket index.
  - If collision occurs, it uses a linked list or balanced tree (Java 8+).
- **Performance**:
  - **Insertion/Deletion/Search**: `O(1)` (Average), `O(n)` (Worst case, if collisions are too high).

### **Example**
```java
Set<Integer> set = new HashSet<>();
set.add(10);
set.add(20);
set.add(10); // Duplicate ignored
System.out.println(set); // Output: [10, 20]
```

---

### **(b) TreeSet (Uses Red-Black Tree)**
#### **Internal Working**
- **Data Structure**: **Self-Balancing Red-Black Tree**.
- **Sorting**: Elements are stored in **sorted order**.
- **Performance**:
  - **Insertion/Deletion/Search**: `O(log n)`

### **Example**
```java
TreeSet<Integer> set = new TreeSet<>();
set.add(20);
set.add(10);
set.add(30);
System.out.println(set); // Output: [10, 20, 30] (Sorted)
```

---

## **3. Queue Implementations**

### **(a) PriorityQueue (Min Heap)**
#### **Internal Working**
- **Data Structure**: **Binary Heap**.
- **Default Behavior**: **Min-Heap** (Smallest element is at the root).
- **Performance**:
  - **Insertion**: `O(log n)`.
  - **Deletion (poll)**: `O(log n)`.

### **Example**
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(30);
pq.offer(10);
pq.offer(20);
System.out.println(pq.poll()); // Output: 10 (Smallest element)
```

---

## **4. Map Implementations**

### **(a) HashMap (Bucket-Based Hashing)**
#### **Internal Working**
- **Data Structure**: **Array + Linked List / Balanced Tree** (Since Java 8).
- **Hashing Process**:
  - `hashCode()` determines the bucket index.
  - If multiple keys map to the same index (collision), it uses a linked list.
  - If collisions exceed **8**, it converts the list to a balanced tree.
- **Performance**:
  - **Insertion/Search**: `O(1)` (Best case), `O(log n)` (Tree case), `O(n)` (Worst case).

### **Example**
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
System.out.println(map.get("A")); // Output: 1
```

---

### **(b) TreeMap (Red-Black Tree)**
#### **Internal Working**
- **Data Structure**: **Red-Black Tree**.
- **Sorting**: Keys are **always sorted**.
- **Performance**:
  - **Insertion/Search**: `O(log n)`

### **Example**
```java
TreeMap<Integer, String> map = new TreeMap<>();
map.put(3, "Three");
map.put(1, "One");
map.put(2, "Two");
System.out.println(map); // Output: {1=One, 2=Two, 3=Three} (Sorted)
```

---

### **(c) ConcurrentHashMap (Thread-Safe HashMap)**
#### **Internal Working**
- **Data Structure**: Segmented Buckets (Multiple small locks).
- **Thread Safety**: Uses **lock striping** (Only locks affected buckets).
- **Performance**:
  - **Insertion/Search**: `O(1)`.
  - **Better than `Hashtable` because only part of the map is locked, not the entire map.**

### **Example**
```java
ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
map.put(1, "A");
map.put(2, "B");
System.out.println(map);
```

---

## **Conclusion**

| **Collection Type** | **Internal Data Structure** | **Best For** |
|----------------|-----------------|------------|
| **ArrayList** | Dynamic Array | Fast access |
| **LinkedList** | Doubly Linked List | Fast insert/delete |
| **HashSet** | HashMap | Unique elements |
| **TreeSet** | Red-Black Tree | Sorted unique elements |
| **PriorityQueue** | Binary Heap | Priority-based access |
| **HashMap** | Hash Table | Fast key-value lookup |
| **TreeMap** | Red-Black Tree | Sorted key-value lookup |
| **ConcurrentHashMap** | Segmented Buckets | Thread-safe key-value |

This document provides a detailed explanation of Java Collections' internal workings. Let me know if you need further details!


