### JOIN
- A `JOIN` clause is used to combine rows from two or more tables, based on a related column between them.

##### Example:
```sql
SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;
```

### INNER JOIN
- The `INNER JOIN` keyword selects records that have matching values in both tables.
- ![image](https://github.com/user-attachments/assets/bee8c8f8-cef4-41c8-8595-ae1c98c3b587)

- The `INNER JOIN` keyword returns only rows with a match in both tables. Which means that if you have a product with no CategoryID, or with a CategoryID that is not present in the Categories table, that record would not be returned in the result.
##### Syntax
```sql
SELECT column_name(s)
FROM table1
INNER JOIN table2
ON table1.column_name = table2.column_name;
```

##### Example
```sql
SELECT ProductID, ProductName, CategoryName
FROM Products
INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID;
```
##### JOIN Three Tables
```sql
SELECT Orders.OrderID, Customers.CustomerName, Shippers.ShipperName
FROM ((Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID)
INNER JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID);
```

### LEFT JOIN
- The `LEFT JOIN` keyword returns all records from the left table (table1), and the matching records from the right table (table2). The result is 0 records from the right side, if there is no match.
##### Syntax
```sql
SELECT column_name(s)
FROM table1
LEFT JOIN table2
ON table1.column_name = table2.column_name;
```
- ![image](https://github.com/user-attachments/assets/67623628-75d4-4ec1-ae22-4cb33fc29eac)
- The `LEFT JOIN` keyword returns all records from the left table (Customers), even if there are no matches in the right table (Orders).
##### Example
```sql
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
ORDER BY Customers.CustomerName;
```
### RIGHT JOIN
- The `RIGHT JOIN` keyword returns all records from the right table (table2), and the matching records from the left table (table1). The result is 0 records from the left side, if there is no match.
- The `RIGHT JOIN` keyword returns all records from the right table (Employees), even if there are no matches in the left table (Orders).
- ![image](https://github.com/user-attachments/assets/38403f1b-fe24-456e-9b15-fd8798b93c6a)

##### Syntax
```sql
SELECT column_name(s)
FROM table1
RIGHT JOIN table2
ON table1.column_name = table2.column_name;
```

##### Example
```sql
SELECT Orders.OrderID, Employees.LastName, Employees.FirstName
FROM Orders
RIGHT JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
ORDER BY Orders.OrderID;
```

### FULL OUTER JOIN
- The `FULL OUTER JOIN` keyword returns all records when there is a match in left (table1) or right (table2) table records.
- The `FULL OUTER JOIN` keyword returns all matching records from both tables whether the other table matches or not. So, if there are rows in "Customers" that do not have matches in "Orders", or if there are rows in "Orders" that do not have matches in "Customers", those rows will be listed as well.
- ![image](https://github.com/user-attachments/assets/c6f6238f-da94-458e-9ed8-9d2897ff7141)

##### Syntax
```sql
SELECT column_name(s)
FROM table1
FULL OUTER JOIN table2
ON table1.column_name = table2.column_name
WHERE condition;
```
##### Example
```sql
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
FULL OUTER JOIN Orders ON Customers.CustomerID=Orders.CustomerID
ORDER BY Customers.CustomerName;
```




