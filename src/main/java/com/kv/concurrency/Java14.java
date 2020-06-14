package com.kv.concurrency;

import java.util.ArrayList;
import java.util.List;

public class Java14 {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("red");
    list.add("alliance");

    for (String current : list) {
      System.out.println(current);
      list.remove(current);
    }
    System.out.println(list);
  }

}
