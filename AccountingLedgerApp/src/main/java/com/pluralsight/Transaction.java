package com.pluralsight;

import java.awt.*;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

/*This is the Transaction class
Serves as a way to get and set date|time|description|vendor|amount
 */
@SuppressWarnings({"FieldMayBeFinal", "unused"})
public class Transaction {

    private String date;
    private String time;
    private String desc;
    private String vendor;
    private float amount;

    public Transaction(String date, String time, String desc, String vendor, float amount) {
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.vendor = vendor;
        this.amount = amount;
    }
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
    public String getDesc() {
        return desc;
    }

    public String getVendor() {
        return vendor;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("%-10s | %-10s | %-40s | %-15s | $%5.2f", getDate(), getTime().format(String.valueOf(dateTimeFormatter)), getDesc(), getVendor(), getAmount());
    }

//    @Override
//     String toString() {
//        DecimalFormat df = new DecimalFormat("0.00");
//        String amountDF = df.format(getAmount());
//        return
//                " Date: " + getDate() + " | " +
//                        "Time: " + getTime() + " | " +
//                        "Description: " + getDesc() + " | " +
//                        "Vendor: " + getVendor() + " | " +
//                        "Amount: $" + amountDF;
//    }
}