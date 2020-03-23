package com.practice.day01.bloomberg.word;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParantheses {

    static boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                deque.offerFirst(s.charAt(i));
            else {
                if (deque.isEmpty())
                    return false;
                else {
                    if (s.charAt(i) == '}' && deque.peekFirst() != '{' ||
                            s.charAt(i) == ')' && deque.peekFirst() != '(' ||
                            s.charAt(i) == ']' && deque.peekFirst() != '[') {
                        return false;
                    }
                    deque.removeFirst();
                }
            }
        }
        return deque.isEmpty();
    }


    public static void main(String[] args) {
        String input = "{[]}";
        System.out.println(isValid(input));
    }

}

