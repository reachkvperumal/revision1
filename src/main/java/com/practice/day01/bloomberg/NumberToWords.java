package com.practice.day01.bloomberg;

public class NumberToWords {

    private final static String[] UNITS = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final static String[] TENS = {"", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};

    private final static String[] THOUSANDS = {"", "Thousand", "Million", "Billion", "Trillion", "Quadrillion",
            "Quintillion"};

    private static String divideByMultiplesOfTen(int number) {
        String current = " ";

        if (number % 100 < 20) {
            current = UNITS[number % 100];
            number /= 100;
        } else {

            current = UNITS[number % 10] + " ";
            number /= 10;

            current = TENS[number % 10] + " " + current;
            number /= 10;
        }

        if (number == 0) return current;
        return UNITS[number] + " Hundred " + current;
    }

    private static String convert(int number) {
        if (number == 0) return "Zero";
        String current = "";
        String prefix = "";
        if (number < 0) {
            prefix = "Negative ";
            number = Math.abs(number);
        }

        int counter = 0;

        do {
            int n = number % 1000;
            if (n > 0) {
                current = divideByMultiplesOfTen(n) + " " + THOUSANDS[counter] + " " + current;
            }
            counter++;
            number /= 1000;
        } while (number > 0);
        return (prefix + " " + current).trim();

    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(convert(Integer.MAX_VALUE));
        System.out.println(convert(-789));

        System.out.println(Integer.MIN_VALUE);
        System.out.println(convert(Integer.MIN_VALUE));
        /*
        one hundred twenty-three million four hundred fifty-six thousand seven hundred eighty-nine
         */
    }

}
