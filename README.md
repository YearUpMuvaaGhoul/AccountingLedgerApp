# AccountingLedgerApp
Accounting Ledger App
Author: Lexx Matula

Overview
This Accounting Ledger App is a Java-based application designed for tracking financial transactions, including deposits and withdrawals, Exporting transaction history to CSV format, and checking account balances by specific dates. This project is part of my capstone project, demonstrating my ability to create a functional, user-friendly financial system using Java.

Features
Add Deposits: Easily add new deposits with relevant details such as date, amount, and description.
Account Balances by Date: Retrieve account balances for any specific date to review financial standing at a particular point in time.
Transaction Logging: Keeps a record of all deposits and withdrawals for clear financial tracking.
How to Use
1. Adding a Deposit
2. Checking Account Balance by Date
To view the account balance on a specific date:

Use the "Check Balance" option and specify the date you're interested in.
The app will calculate the balance based on all transactions made up to that date.
Example:

3. accessing the ledger
4. Returning or exiting to home screen 


When thinking about how to make my project user friendly, I took a lot of care in designing the layout of my project. As seen in this screenshot, there are 6 classes.

AccountingLedgerApp: Here you'll find my main method and all of the Screens for my app.
HomeFunctions: Stores all of the functioning code for my homeScreen.
LedgerFunctions: Stores all of the functioning code for my ledgerScreen.
ReportsFunctions: Stores all of the functioning code for my reportsScreen.
Transaction: A class for constructing and getting my private Transaction values.
Reader: A class for storing my buffered/file readers.

Technical Information
Language: Java
Purpose: Capstone Project 1 Backend LTCA 
Instructor: Matt Christenson

Future Enhancements
Adding support for multiple accounts.
Integration of additional transaction types such as transfers and recurring payments.


