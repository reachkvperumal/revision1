package com.practice.day02.generics;

public class LooselyCoupled<T extends Comparable<? extends Number>> {

  private T t;

  public LooselyCoupled(T t) {
    this.t = t;
  }

  public void show() {
    System.out.println(this.t);
  }
}
