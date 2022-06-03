package com.algo.recursion.day02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVModifier {
    private final static String MONTH_PATTERN = "(\\d+-)(\\w{3})(.+)";
    private final static String sourceDateTime = "06-DEC-21 01.23.48.303369000 AM";
    private final static String sourceDateTimeFormat = "dd-MMM-yy HH.mm.ss.SSSSSSSSS a";

    private final static String expectedDateTime = "06/12/2021 01:23:48 AM";
    private final static String expectedDateTimeFormat = "dd/MM/yyyy HH:mm:ss a";

    public static void main(String[] args) {
        LocalDateTime parsedDateTime = LocalDateTime.parse(updateMonth(sourceDateTime), DateTimeFormatter.ofPattern(sourceDateTimeFormat));
        System.out.printf("Parsed Date Time from \"sourceDateTime\" => %s%n", parsedDateTime);
        String targetDateTime = parsedDateTime.format(DateTimeFormatter.ofPattern(expectedDateTimeFormat));
        System.out.printf("Expected Date Time => %s%n", targetDateTime);
        System.out.printf("Now compare \"expectedDateTime\" with \"targetDateTime\" => %b%n", targetDateTime.equals(expectedDateTime));
    }

    private static String updateMonth(String srcDt){

        Matcher matcher = Pattern.compile(MONTH_PATTERN).matcher(srcDt);
        if(matcher.find()){
            String group = matcher.group(2);
            String result = matcher.group(1)+group.substring(0,1)+group.substring(1).toLowerCase()+matcher.group(3);
            System.out.printf("Original Month => %s%nUpdated. Month => %s%n",srcDt,result);
            return result;
        }
        return srcDt;

    }
}
