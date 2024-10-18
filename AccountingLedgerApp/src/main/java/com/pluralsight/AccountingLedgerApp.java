package com.pluralsight;

import java.io.IOException;
import java.util.Scanner;
import static com.pluralsight.HomeFunctions.*;
import static com.pluralsight.LedgerFunctions.*;
import static com.pluralsight.Reader.readTransactions;
import static com.pluralsight.Reader.transactionList;
import static com.pluralsight.ReportsFunctions.*;


/*Welcome to the Main Class for my Accounting Ledger App
Here is where the Screens of my App will live
The Home screen will allow users to:
    D) Add deposit: Prompt user for deposit info and save to csv file
    P) Make payment: Prompt user for info (What it's for and who/amount) and save to csv file
    L) Ledger - Display the Ledger Screen
    X) Exit - Exit app
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
    public static void main(String[] args) throws IOException {
        readTransactions();
    }

    public static void homeScreen() throws IOException {
        System.out.println("Good afternoon, User. How can I assist you?");
        System.out.println(" D) Add a Deposit \n P) Make a Payment \n L) View your Ledger \n X) Exit");
        String lexxsChoice = scanner.nextLine().toUpperCase().trim();
        switch(lexxsChoice) {
            case "D": addDeposit();
            case "P": makePayment();
            case "L": ledgerScreen();
            case "X": System.exit(0);
            default:
                scanner.nextLine();
                System.out.println("I'm having a hard time finding what you're looking for. Please try again, make sure your response is D, P, L, or X.");
                homeScreen();
        }
    }

    public static void ledgerScreen() throws IOException {
        System.out.println("Welcome to your Ledger, which transaction history would you like to view?");
        System.out.println(" A) Display all transactions \n D) Display all deposits \n P) Display payment history \n R) Search my Reports \n H) Return Home");
        System.out.println("Number of transactions: " + transactionList.size());

        String lexxStatements = scanner.nextLine().toUpperCase().trim();
        switch(lexxStatements) {
            case "A": displayAll();
            case "D": displayDeposits();
            case "P": displayPayments();
            case "R": reportsScreen();
            case "H": homeScreen();
            default:
                System.out.println("I'm having a hard time finding what you're looking for. Please try again, make sure your response is A, D, P, or R.");
                ledgerScreen();
        }
    }

    public static void reportsScreen() throws IOException {
        System.out.println("Welcome to your Reports, how would you like to view your statements?");
        System.out.println(" 1) Month to Date \n 2) Previous Month \n 3) Year to Date \n 4) Previous Year \n 5) Search by Vendor \n 0) Return Home");
        int lexxReports = scanner.nextInt();
        switch(lexxReports) {
            case 1: monthToDate();
            case 2: previousMonth();
            case 3: yearToDate();
            case 4: previousYear();
            case 5: scanner.nextLine();
                searchByVendor();
            case 0: homeScreen();
            default:
                System.out.println("I'm having a hard time finding what you're looking for. Please try again, make sure your response is 1, 2, 3, 4, 5, or 0");
                reportsScreen();
        }
    }
}
