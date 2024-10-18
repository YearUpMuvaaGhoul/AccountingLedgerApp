package com.pluralsight;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import static com.pluralsight.AccountingLedgerApp.*;
import static com.pluralsight.Reader.transactionList;

/*This is my ReportsFunctions class
In this class you'll find the following methods:
monthToDate();
previousMonth();
yearToDate();
previousYear();
searchByVendor(); -Should have an additional "return home" option
 */
public class ReportsFunctions {

    public static Scanner scan = new Scanner(System.in);

    public static void monthToDate() throws IOException {
        //[0] - Year, [1] - Month, [2] - Day
        System.out.println("Here are your Month to Date statements:");
        for (Map.Entry<String, Transaction> dateSet : transactionList.entrySet()) {
            String[] splitDates = dateSet.getValue().getDate().split("-");
            LocalDate today = LocalDate.now();
            int thisMonth = today.getMonthValue();
            int dayOfMonth = today.getDayOfMonth();
            if ((Integer.parseInt(splitDates[1]) == thisMonth) && (Integer.parseInt(splitDates[2]) <= dayOfMonth)) {
                System.out.println(dateSet.getValue().toString());
            }
        }
        System.out.println("Press 'X' when you're ready to return to the Reports menu");
        String exit = scan.nextLine().toUpperCase().trim();
        if (exit.equals("X")) {
            System.out.println("Redirecting to Reports menu...");
            reportsScreen();
        } else {
            System.out.println("Sorry, didn't catch that. Press 'X' to return to the Reports Menu");
            monthToDate();
        }
    }

    public static void previousMonth() throws IOException {
        System.out.println("Here are your statements from the Previous Month:");
        for (Map.Entry<String, Transaction> dateSet : transactionList.entrySet()) {
            String[] splitDates = dateSet.getValue().getDate().split("-");
            LocalDate today = LocalDate.now();
            int thisMonth = today.getMonthValue();
            int previousMonth;
            if ((Integer.parseInt(splitDates[1])) == 1) {
                previousMonth = 12;
            } else {
                previousMonth = thisMonth - 1;
            }
            if ((Integer.parseInt(splitDates[1]) == previousMonth)) {
                System.out.println(dateSet.getValue().toString());
            }
        }
        System.out.println("Press 'X' when you're ready to return to the Reports menu");
        String exit = scan.nextLine().toUpperCase().trim();
        if (exit.equals("X")) {
            System.out.println("Redirecting to Reports menu...");
            reportsScreen();
        } else {
            System.out.println("Sorry,ERROR - Press 'X' to return to the Reports Menu");
            monthToDate();
        }
    }

    public static void yearToDate() throws IOException {
        System.out.println("Here are your Year 2 Date statements:");
        for (Map.Entry<String, Transaction> dateSet : transactionList.entrySet()) {
            String[] splitDates = dateSet.getValue().getDate().split("-");
            LocalDate today = LocalDate.now();
            int thisYear = today.getYear();
            if ((Integer.parseInt(splitDates[0])) == ((thisYear))) {
                System.out.println(dateSet.getValue().toString());
            }
        }
        System.out.println("Press 'X' when you're ready to return to the Reports menu");
        String exit = scan.nextLine().toUpperCase().trim();
        if (exit.equals("X")) {
            System.out.println("Redirecting to Reports menu...");
            reportsScreen();
        } else {
            System.out.println("Sorry, didn't catch that. Press 'X' to return to the Reports Menu");
            yearToDate();
        }
    }

    public static void previousYear() throws IOException {
        System.out.println("Here are your Previous Year statements:");
        for (Map.Entry<String, Transaction> dateSet : transactionList.entrySet()) {
            String[] splitDates = dateSet.getValue().getDate().split("-");
            LocalDate today = LocalDate.now();
            int previousYear = today.getYear() - 1;
            if ((Integer.parseInt(splitDates[0])) == ((previousYear))) {
                System.out.println(dateSet.getValue().toString());
            }
        }
        System.out.println("Press 'X' when you're ready to return to the Reports menu");
        String exit = scan.nextLine().toUpperCase().trim();
        if (exit.equals("X")) {
            System.out.println("Redirecting to Reports menu...");
            reportsScreen();
        } else {
            System.out.println("Sorry,ERROR-. Press 'X' to return to the Reports Menu");
            previousYear();
        }
    }

    public static void searchByVendor() throws IOException {
        System.out.println("Search your statements by vendor \n Please enter the vendor name for your search: ");
        String vendorSearch = scanner.nextLine();
        System.out.println("Here are the vendors matching your search value:");
        int i = 0;
        for(Map.Entry<String, Transaction> vendorList : transactionList.entrySet()) {
            if (vendorList.getValue().getVendor().equalsIgnoreCase(vendorSearch)) {
                System.out.println(vendorList.getValue().toString());
                i++;
            }
        }
        if(i == 0) {
            System.out.println("Sorry, ERROR  we couldn't find a match for that vendor. Please try a new vendor search.");
            searchByVendor();
        }
        System.out.println(" Press 'V' to start a new Vendor Search \n Press 'H' to return home");
        String exitMenu = scan.next().toUpperCase().trim();
        if(exitMenu.contains("V")) {
            searchByVendor();
        }
        if(exitMenu.contains("H")) {
            homeScreen();
        }
        else {
            System.out.println("I didn't catch that, I'll redirect you to the Vendor Search.");
            searchByVendor();
        }
    }
}