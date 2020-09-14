package com.algo.recursion.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AllDecimalStrings {

  private static void compute(int digit) {
    helper(digit, new ArrayList<>());
  }

  private static void helper(int digit, List<Integer> result) {
    if (digit == 0) {
      System.out.println(result);
    } else {
      IntStream.rangeClosed(0, 9).forEach(i -> {
        result.add(i);
        helper(digit - 1, result);
        result.remove(result.size() - 1);
      });
    }
  }


  public static void main(String[] args) {
    compute(2);
  }

}
