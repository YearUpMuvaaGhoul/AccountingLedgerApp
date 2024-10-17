package com.pluralsight;


import java.io.IOException;
import java.util.*;

import static com.pluralsight.Reader.readTransactions;
import static com.pluralsight.Reader.transactionList;



/* This the Main Class for my Accounting Ledger App
Here is where the Screens of my App will live
The Home screen will allow users to:
    D) Add deposit: Prompt user for deposit info and save to csv file
    P) Make payment: Prompt user for debit info and save to csv file
    L) Ledger - Display Ledger
    X) Exit - Exit

The Ledger Screen will allow users to:
    Show the newest entries first
    A) All: Display all entries
    D) Deposits: Display entries that are only deposits
    P) Payments: Display only the negative entries (payments)
    R) Reports: New screen for running pre-defined reports/making custom searches
    H) Return Home
The Reports Screen will allow users to:
    1) Month to Date
    2) Previous Month
    3) Year to Date
    4) Previous Year
    5) Search by Vendor: Prompt user for vendor name and display all entries for that vendor
           - Back: Go back to Report page
    H) Return Home
 */
public class AccountingLedgerApp {
    public static Scanner scanner = new Scanner(System.in);
    //RAM
    static HashMap<String, Transaction> transactionList = readTransactions(); // storing all the entries or transactions
    static HashMap<String, Transaction> transactionWithDeposits= new HashMap<>(); // storing deposit entries or transactions
    static HashMap<String, Transaction> transactionWithPayments = new HashMap<>(); // storing payment entries or negative transactions

  // create three objects of them and call their functions. or using their functions
    static ReportsFunctions reportsFunctions  = new ReportsFunctions();
    static HomeFunctions homeFunctions = new HomeFunctions();
    static LedgerFunctions ledgerFunctions = new LedgerFunctions();

    public static void main(String[] args) throws IOException {
        homeScreen();
        utilizingEachFunctions(); // issues.
    }
/// ask gabe not passing list (hashmap thru each function) or deposit and also create line break when adding
    public static void utilizingEachFunctions() {
        reportsFunctions.setUpData(transactionList);
        homeFunctions.setUpData(transactionWithDeposits, transactionWithPayments, transactionList);
        ledgerFunctions.setUpData(transactionWithDeposits, transactionWithPayments, transactionList);
    }

    public static void homeScreen() throws IOException {
        System.out.println("Hello, User. How can I assist you today?");
        System.out.println(" D) Add a Deposit \n P) Make a Payment \n L) View Ledger \n X) Exit");
        String lexxsChoice = scanner.nextLine().toUpperCase().trim();
        switch(lexxsChoice) {
            case "D": homeFunctions.addDeposit();
            case "P": homeFunctions.makePayment();
            case "L": ledgerScreen();
            case "X": System.exit(0);
            default:
                scanner.nextLine();
                System.out.println("ERROR-- Please try again, acceptable entries are D, P, L, or X.");
                homeScreen();
        }
    }

    public static void ledgerScreen() throws IOException {
        System.out.println("Welcome to your Ledger, which transaction history would you like to see?");
        System.out.println(" A) Display all transactions \n D) Display all deposits \n P) Display payment history \n R) Search my Reports \n H) Return Home");
        String LexxStatements = scanner.nextLine().toUpperCase().trim();
        switch(LexxStatements) {
            case "A": ledgerFunctions.displayAll();
            case "D": ledgerFunctions.displayDeposits();
            case "P": ledgerFunctions.displayPayments();
            case "R": reportsScreen();
            case "H": homeScreen();
            default:
                System.out.println("ERROR-- Please try again, acceptable entries are A, D, P, or R.");
                ledgerScreen();
        }
    }

    public static void reportsScreen() throws IOException {
        System.out.println("Welcome to your Reports, how would you like to view your statements?");
        System.out.println(" 1) Month to Date \n 2) Previous Month \n 3) Year to Date \n 4) Previous Year \n 5) Search by Vendor \n 0) Return Home");
        int lexxsReports = scanner.nextInt();
        switch(lexxsReports) {
            case 1: reportsFunctions.monthToDate();
            case 2: reportsFunctions.previousMonth();
            case 3: reportsFunctions.yearToDate();
            case 4: reportsFunctions.previousYear();
            //case 5: scanner.nextLine();
                reportsFunctions.searchByVendor();
            case 0: homeScreen();
            default:
                System.out.println("ERROR-- Please try again, acceptable entries are  1, 2, 3, 4, 5, or 0");
                reportsScreen();
        }
    }
}
///need to update csv file not just read.. need to pass through array list