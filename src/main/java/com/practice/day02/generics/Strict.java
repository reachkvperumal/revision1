package com.practice.day02.generics;

public class Strict<T extends Number & Comparable<T>> {

  private T t;

  public Strict(T t) {
    this.t = t;
  }

  public T getT() {
    return t;
  }

  public void show() {
    System.out.println(t);
  }

}
