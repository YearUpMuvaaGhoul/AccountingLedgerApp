package com.pluralsight;

import java.io.*;
import java.util.*;
import static com.pluralsight.AccountingLedgerApp.homeScreen;

/*This is the Reader Class
Here is where my buffered/file reader is stored
When launched, my main method will start the readTransactions method automatically
 */
public class Reader {
    public static HashMap<String, Transaction> transactionList = new HashMap<>();

    public static void readTransactions() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
        BufferedReader bufReader = new BufferedReader(fileReader);
        String csv;
        while ((csv = bufReader.readLine()) != null) {
            String[] transactionLedger = csv.split("\\|");
            if (!transactionLedger[0].contains("date")) {
                String date = transactionLedger[0];
                //String time = transactionLedger[1];
                String time = "";
                if (transactionLedger.length > 1) {
                    time = transactionLedger[1];
                } else {
                    System.out.println("Transaction ledger has insufficient data.");

                    String desc = transactionLedger[2];
                    String vendor = transactionLedger[3];
                    float amount = Float.parseFloat(transactionLedger[4]);
                    Transaction newTransaction = new Transaction(date, time, desc, vendor, amount);
                    transactionList.put(date + time, newTransaction);
                }
            }
            homeScreen();
            fileReader.close();
            bufReader.close();
        }
    }
}