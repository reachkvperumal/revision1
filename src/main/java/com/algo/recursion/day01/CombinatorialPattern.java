package com.algo.recursion.day01;

import java.util.ArrayList;
import java.util.List;

public class CombinatorialPattern {

  static List<String> compute(String input) {

    if (input != null && input.length() > 0) {
      List<String> result = new ArrayList<>();
      helper(input, 0, new char[input.length()], result);
      return result;
    }

    return null;
  }

  static void helper(String input, int count, char[] buf, List<String> result) {
    if (input.length() == count) {
      result.add(new String(buf));
    } else {
      char c = input.charAt(count);
      if (Character.isAlphabetic(c)) {
        buf[count] = Character.toLowerCase(c);
        helper(input, count + 1, buf, result);
        buf[count] = Character.toUpperCase(c);
        helper(input, count + 1, buf, result);

      } else {
        buf[count] = input.charAt(count);
        helper(input, count + 1, buf, result);
      }
    }
  }


  public static void main(String[] args) {
    System.out.println(compute("a1b2"));
    System.out.println(compute("12345"));
  }

}
