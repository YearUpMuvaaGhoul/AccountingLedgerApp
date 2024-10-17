package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import static com.pluralsight.AccountingLedgerApp.homeScreen;

/*This is the Reader Class
Here is where my buffered/file reader is stored
When launched, my main method will start the readTransactions method automatically
 */
public class Reader {
    public static HashMap<String, Transaction> transactionList = new HashMap<>();
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static HashMap<String, Transaction> readTransactions()  {
        try {
            FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String csv;
            while ((csv = bufReader.readLine()) != null) {
                String[] transactionLedger = csv.split("\\|");
                if(!transactionLedger[0].contains("date")) {
                    String date = transactionLedger[0];
                    String time = transactionLedger[1];
                    String desc = transactionLedger[2];
                    String vendor = transactionLedger[3];
                    float amount = Float.parseFloat(transactionLedger[4]);
                    LocalDate createdDate = LocalDate.parse(date, dateFormatter);
                    LocalTime createdTime = LocalTime.parse(time, timeFormatter);
                    Transaction newTransaction = new Transaction(createdDate, createdTime, desc, vendor, amount);
                    transactionList.put(date + time, newTransaction);
                }
            }
            fileReader.close();
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactionList;
    }
}