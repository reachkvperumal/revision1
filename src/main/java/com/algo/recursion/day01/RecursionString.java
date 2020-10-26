package com.algo.recursion.day01;

public class RecursionString {

  private static String reverseString(String str) {
    if (str.isBlank()) {
      return str;
    } else {
      return reverseString(str.substring(1)) + str.charAt(0);
    }
  }

  private static String removeDuplicates(String str) {
    if (str.length() == 1) {
      return str;
    }
    if (str.substring(0, 1).equalsIgnoreCase(str.substring(1, 2))) {
      return removeDuplicates(str.substring(1));
    } else {
      return str.substring(0, 1) + removeDuplicates(str.substring(1));
    }
  }

  public static void main(String[] args) {
    String java = "JAVA";
    System.out.println(reverseString(java));

    System.out.println(removeDuplicates("Thiss iiss aa teesstt"));


  }

}
