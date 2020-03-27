package com.practice.day01.bloomberg.word;

public class ReverseWordsInString {

    static String reverse(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("Let's take LeetCode contest"));
    }
}
