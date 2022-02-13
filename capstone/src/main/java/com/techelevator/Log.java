package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    // Class variables
    public static final int ERROR_PRINTING_LOG = 2;

    public static String addRecord(String transaction, BigDecimal startBalance, BigDecimal endBalance) {
        // Setup DateTime format
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        // Get current DateTime
        String formattedDate = dateTimeFormatter.format(LocalDateTime.now());
        String record = String.format("%s %s $%s $%s", formattedDate, transaction, startBalance, endBalance);
        Log.printRecordToLog(record);
        return record; // for testing
    }

    private static void printRecordToLog(String record) {
        try (PrintWriter logFile = new PrintWriter(new FileWriter("log.txt", true))) {
            logFile.println(record);
        } catch (IOException e) {
            System.out.println("Error: Out of order");
            System.exit(ERROR_PRINTING_LOG); // the system not logging transactions is a major error
        }
    }
}
