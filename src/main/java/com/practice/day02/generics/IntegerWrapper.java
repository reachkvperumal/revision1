package com.practice.day02.generics;

public class IntegerWrapper implements Comparable<Integer> {

  private Integer i;

  public IntegerWrapper(Integer i) {
    this.i = i;
  }

  @Override
  public int compareTo(Integer o) {
    return this.i.compareTo(o);
  }

  @Override
  public String toString() {
    return String.valueOf(this.i);
  }
}
