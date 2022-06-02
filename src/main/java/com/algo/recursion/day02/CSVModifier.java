package com.algo.recursion.day02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSVModifier {
    private final static String sourceDateTime = "06-Dec-21 01.23.48.303369000 AM";
    private final static String sourceDateTimeFormat = "dd-MMM-yy HH.mm.ss.SSSSSSSSS a";

    private final static String expectedDateTime = "06/12/2021 01:23:48 AM";
    private final static String expectedDateTimeFormat = "dd/MM/yyyy HH:mm:ss a";

    public static void main(String[] args) {
        LocalDateTime parsedDateTime = LocalDateTime.parse(sourceDateTime, DateTimeFormatter.ofPattern(sourceDateTimeFormat));
        System.out.printf("Parsed Date Time from \"sourceDateTime\" => %s%n", parsedDateTime);
        String targetDateTime = parsedDateTime.format(DateTimeFormatter.ofPattern(expectedDateTimeFormat));
        System.out.printf("Expected Date Time => %s%n", targetDateTime);
        System.out.printf("Now compare \"expectedDateTime\" with \"targetDateTime\" => %b%n", targetDateTime.equals(expectedDateTime));
    }
}
