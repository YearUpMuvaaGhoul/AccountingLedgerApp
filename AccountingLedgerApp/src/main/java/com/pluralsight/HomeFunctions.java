package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import static com.pluralsight.AccountingLedgerApp.homeScreen;
import static com.pluralsight.AccountingLedgerApp.scanner;

/*This is my HomeFunctions class
Here you'll find the following methods:
addDeposits(); - Allows user to enter new deposit into transactions.csv
makePayment(); - Allows user to detail payments from their account into transactions.csv
 by adding what vendor how much and a description of what it is like a check, an applepay receieved, etc


 */

public class HomeFunctions {

    public DecimalFormat df = new DecimalFormat("0.00");
    public DateTimeFormatter hms = DateTimeFormatter.ofPattern("HH:mm:ss");

    //RAM
    HashMap<String, Transaction> transactionList; // storing all the entries or transactions
    HashMap<String, Transaction> transactionWithDeposits; // storing deposit entries or transactions
    HashMap<String, Transaction> transactionWithPayments; // storing payment entries or negative transactions

    public HomeFunctions(){}
    public void setUpData(HashMap<String, Transaction> transactionWithDeposits, HashMap<String, Transaction> transactionWithPayments, HashMap<String, Transaction> transactionList) {
        this.transactionList = transactionList;
        this.transactionWithPayments = transactionWithPayments;
        this.transactionWithDeposits = transactionWithDeposits;
    }

    public void addDeposit() throws IOException {
        System.out.println("In order to add a new Deposit to your transaction history, we will need a little information");
        System.out.println("Please provide a description for your deposit \n Example: Paycheck");
        String desc = scanner.nextLine();
        System.out.println("Got it, and what vendor provided this Deposit? \n Example: Bonus Room Bar LLC");
        String vendor = scanner.nextLine();
        System.out.print("Finally, what amount is this deposit for? \n Example: 100.00 \n $");
        float amount = scanner.nextFloat();
        scanner.nextLine();
        String amountDF = df.format(amount);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transaction transaction = new Transaction(date, time, desc, vendor, Float.parseFloat(amountDF));
        transactionWithDeposits.put(vendor, transaction);

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
        fileWriter.write(date + "|" + time + "|" + desc + "|" + vendor + "|" + amountDF + \n);
        fileWriter.newLine();
        fileWriter.close();
        System.out.println("Your deposit was received! We will redirect you to Account Home now...");
        homeScreen();
    }

    // csv is disk,  but arraylist is ram.
    // computer does not ram. every operations you operate on disk or csv file. you dont have ram.

    public void makePayment() throws IOException {
        System.out.println("To get started making a Payment, we will need a little information.");
        System.out.println("Please provide a description for your payment \n Example: Phone Bill");
        String desc = scanner.nextLine();
        System.out.println("Got it, and what vendor is this payment being made to? \n Example: T-Mobile");
        String vendor = scanner.nextLine();
        System.out.print("Finally, what amount is this payment for? \n Example: 45.00 \n $");
        float amount = scanner.nextFloat();
        scanner.nextLine();
        amount *= -1;
        String amountDF = df.format(amount);

        String date = String.valueOf(LocalDate.now());
        String time = hms.format(LocalTime.now());

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
        fileWriter.write(date + "|" + time + "|" + desc + "|" + vendor + "|" + amountDF);
        fileWriter.newLine();
        fileWriter.close();

        System.out.println("Thank you for your payment! We will redirect you to Account Home now...");
        homeScreen();
    }
}