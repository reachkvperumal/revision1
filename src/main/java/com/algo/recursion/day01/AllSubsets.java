package com.algo.recursion.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSubsets {

  private static List<String> compute(int[] digit) {
    List<String> result = new ArrayList<>();
    helper(digit, 0, new StringBuffer(), result);
    Collections.sort(result, (o1, o2) -> {
      if (o1.length() > 0 && o2.length() > 0) {
        int i = Integer.parseInt(o1);
        int i1 = Integer.parseInt(o2);
        return Integer.compare(i, i1);
      }
      return 0;
    });
    return result;
  }

  private static void helper(int[] digit, int idx, StringBuffer sb, List<String> result) {
    if (digit.length == idx) {
      result.add(sb.toString());
    } else {
      helper(digit, idx + 1, sb, result); //exclude
      sb.append(digit[idx]);
      helper(digit, idx + 1, sb, result); // include
      sb.deleteCharAt(sb.length() - 1);

    }
  }

  public static void main(String[] args) {
    System.out.println(compute(new int[]{1, 2, 3}));
  }
}
