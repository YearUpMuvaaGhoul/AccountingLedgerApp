package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.pluralsight.AccountingLedgerApp.homeScreen;
import static com.pluralsight.AccountingLedgerApp.scanner;

/*This is my HomeFunctions class
Here you'll find the following methods:
addDeposits(); - Allows user to enter new deposit into transactions.csv
makePayment(); - Allows user to notate payments from their account into transactions.csv
 */

public class HomeFunctions {

    public static DecimalFormat df = new DecimalFormat("0.00");
    public static DateTimeFormatter hms = DateTimeFormatter.ofPattern("HH:mm:ss");


    public static void addDeposit() throws IOException {
        System.out.println("In order to add a new Deposit to your transaction history, we will need a little information from you.");
        System.out.println("Please provide a description for your deposit \n Example: Paycheck");
        String desc = scanner.nextLine();
        System.out.println("Got it, and what vendor provided this Deposit? \n Example: The UPS Store");
        String vendor = scanner.nextLine();
        System.out.print("Finally, what amount is this deposit for? \n Example: 100.00 \n $");
        float amount = scanner.nextFloat();
        scanner.nextLine();
        String amountDF = df.format(amount);

        String date = String.valueOf(LocalDate.now());
        String time = hms.format(LocalTime.now());

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
        fileWriter.write(date + "|" + time + "|" + desc + "|" + vendor + "|" + amountDF);
        fileWriter.newLine();
        fileWriter.close();
        System.out.println("Your deposit was received! We will redirect you to Account Home now...");
        homeScreen();
    }

    public static void makePayment() throws IOException {
        System.out.println("To get started making a Payment, we will need a little information from you.");
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