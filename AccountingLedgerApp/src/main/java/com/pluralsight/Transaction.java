package com.pluralsight;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

/*This is the Transaction class
Serves as a way to get and set date|time|description|vendor|amount
 */
@SuppressWarnings({"FieldMayBeFinal", "unused"})
public class Transaction {

    private LocalDate date;
    private LocalTime time;
    private String desc;
    private String vendor;
    private float amount;

    public Transaction(LocalDate date, LocalTime time, String desc, String vendor, float amount) {
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.vendor = vendor;
        this.amount = amount;
    }
    public String getDate() {
        return date.toString();
    }

    public String getTime() {
        return time.toString();
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
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String amountDF = df.format(amount);
        return
                " Date: " + date + " | " +
                        "Time: " + time + " | " +
                        "Description: " + desc + " | " +
                        "Vendor: " + vendor + " | " +
                        "Amount: $" + amountDF;
    }
}