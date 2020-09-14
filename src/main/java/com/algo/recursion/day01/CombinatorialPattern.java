package com.algo.recursion.day01;

import java.util.ArrayList;
import java.util.List;

public class CombinatorialPattern {

  private static List<String> compute(String input) {
    List<String> result = new ArrayList<>();
    if (input != null && input.length() > 0) {
      helper(input, 0, new char[input.length()], result);
    }
    return result;
  }

  /**
   * Time complexity: O(2^n+1 * n) Space Complexity: O(2^n * n + n^2)
   *
   * @param input
   * @param count
   * @param buf
   * @param result
   */
  private static void helper(String input, int count, char[] buf, List<String> result) {
    if (input.length() == count) {
      result.add(new String(buf));
    } else {
      char c = input.charAt(count);
      if (Character.isAlphabetic(c)) {
        buf[count] = Character.toUpperCase(c);
        helper(input, count + 1, buf, result);
        buf[count] = Character.toUpperCase(c);
        helper(input, count + 1, buf, result);
      } else {
        buf[count] = c;
        helper(input, count + 1, buf, result);
      }
    }
  }


  public static void main(String[] args) {
    System.out.println(compute("a1b2"));
    System.out.println(compute("12345"));
  }

}
