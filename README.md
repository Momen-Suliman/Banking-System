# Simple Banking System

A Java simulation of a basic banking system using a custom generic stack (for account inventory) and a custom generic queue (for customer line management). Customers are assigned either a Checking or Savings account and put through a series of transactions, with results written to a text file.

## Project Structure

| File | Role |
| :--- | :--- |
| **Accounts.java** | Abstract base class for all account types |
| **Checking.java** | Checking account — overdraft allowed |
| **Savings.java** | Savings account — overdraft blocked |
| **AccountStack.java** | Generic stack that holds accounts |
| **Customer.java** | Holds a customer's name, ID, and account |
| **CustomerQueue.java** | Generic linked-list queue for the customer line |
| **Statements.java** | Utility class for printing account info |
| **Simulation.java** | Main simulation — runs the full bank day |
| **Main.java** | Serialization demo — writes/reads customers to a file |

## Prerequisites

*   **Java 17 or later** — verify with `java -version`
*   **JUnit 5**

## Running the Simulation

```bash
# 1. Compile everything
javac *.java

# 2. Run the bank simulation (writes results to Program7.txt)
java Simulation

# 3. Open the output file to see customer statements
cat Program7.txt
```
## Running the Serialization Demo

```bash
# After compiling, run Main
# This writes 10 customers to a binary file then reads them back
java Main
```

## Running the Tests

```bash
# 1. Download JUnit 5 (one time only)
curl -L https://repo1.maven.org \
  -o junit-platform-console-standalone.jar

# 2. Compile source + tests
javac -cp junit-platform-console-standalone.jar -d out *.java

# 3. Run the tests
java -jar junit-platform-console-standalone.jar \
  --class-path out \
  --select-class BankingTests
```
