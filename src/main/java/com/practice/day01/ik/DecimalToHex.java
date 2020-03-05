package com.practice.day01.ik;

public class DecimalToHex {

    static String hex(int num) {
        System.out.println(num);
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            builder.append(hex[num % 16]);
            num /= 16;
        }
        return "0x" + builder.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println("0x7fffffff");
        System.out.println(hex(Integer.MAX_VALUE));
        System.out.println(hex(1_000_000_007));
        System.out.println(0x3B9ACA07);
    }
}
