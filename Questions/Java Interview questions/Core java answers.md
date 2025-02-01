## Why strings are Immutable.
  - **String Pool**: Java stores string literals in a pool to save memory. Immutability ensures one reference does not change the value for others pointing to the same string.
  - **Security**: Strings are used for sensitive data like usernames and passwords. Immutability prevents attackers from altering the values.
  - **Thread Safety**: Since string values cannot be changed, they are automatically thread-safe, means multiple threads can safely use the same string.
  - **Efficiency**: The JVM reuses strings in the String Pool by improving memory usage and performance.
