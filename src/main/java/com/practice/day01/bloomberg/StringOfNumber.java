package com.practice.day01.bloomberg;

import java.io.Serializable;
import java.util.Arrays;

public class StringOfNumber implements Serializable {

    private static final long serialVersionUID = 8932413803928978771L;

    static String formatNumber(int num) {
        System.out.println(num);
        int count = 0;
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            if (count > 0 && count % 3 == 0)
                builder.append(',');

            builder.append((char) ('0' + num % 10));
            count++;
            num /= 10;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        int[] v = {Integer.MAX_VALUE, 0x7ffffff, 0x7fffff, 0x7ffff, 0x7fff, 0x7ff, 0x7f};
        Arrays.stream(v).mapToObj(StringOfNumber::formatNumber).forEach(System.out::println);
    }

}
