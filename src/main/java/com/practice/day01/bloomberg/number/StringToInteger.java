package com.practice.day01.bloomberg.number;

public class StringToInteger {

    static int compute(String s) {
        if (s == null || s == "")
            return 0;

        s = s.trim();

        int i = 0;
        char flag = '+';
        if (s.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        double result = 0;

        while (s.length() > i && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + (s.charAt(i) - '0');
            i++;
        }
        if (flag == '-')
            result = -result;
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    public static void main(String[] args) {
        String s = "4193 with words";
        System.out.println(compute(s));
    }
}
