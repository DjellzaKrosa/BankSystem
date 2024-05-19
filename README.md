# Bank System Java Application

## Overview

This Java application simulates a basic banking system, allowing users to perform various banking operations.

## Features

- Create a bank with all required values
- Create an account
- Perform both flat fee and percent fee transaction from one account to another
- Withdraw and deposit money to an account
- See list of transactions for any account
- Check account balance for any account
- See list of bank accounts
- Check bank total transaction fee amount
- Check bank total transfer amount

## How It Works

The application consists of several classes:

- `Account`: Represents a bank account with attributes like accountId, userName, balance, and a list of transactions. Provides methods to deposit, withdraw, add transactions, and retrieve account information.
- `Bank`: Manages multiple accounts within the bank. Provides functionalities to create accounts, find account by ID, deposit/withdraw money, transfer funds between accounts, and retrieve account information and transaction details.
- `Transaction`: Abstract class representing a financial transaction. Contains common attributes like amount, originating account ID, resulting account ID, and transaction reason.
Provides abstract methods to calculate transaction fees and total transaction amounts.
- `FlatFeeTransaction and PercentFeeTransaction`: Subclasses of Transaction representing different types of transaction fees (flat fee or percentage fee). Implements methods to calculate the transaction fee and total transaction amount based on the specific fee type.
-  `BankTest`: Main class containing the main method to run the Bank System application. Provides a text-based menu interface for users to interact with the bank functionalities.

## Usage

1. Compile the Java files using a Java compiler.
2. Run the `BankTest` class.
3. Follow the command-line instructions to perform various banking operations.

    ### Console Interface
   
***Bank System***

Enter bank name: 

Bank System Menu:
1. Create Account
2. Deposit
3. Withdraw
4. Transfer
5. View transactions
6. View account balance
7. List of bank accounts
8. Check bank total transaction fee amount
9. Check bank total transfer amount
10. Exit

Enter your choice:
