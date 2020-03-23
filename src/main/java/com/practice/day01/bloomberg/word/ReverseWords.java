package com.practice.day01.bloomberg.word;

public class ReverseWords {
    private static String reverse(String text) {

        String[] split = text.split("\\s");
        StringBuilder sb = new StringBuilder();

        for (int i = split.length - 1; i >= 0; i--) {

            sb.append(split[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("i love programming very much"));
    }
}
