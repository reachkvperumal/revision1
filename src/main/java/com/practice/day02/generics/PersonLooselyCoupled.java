package com.practice.day02.generics;

public class PersonLooselyCoupled<T extends Comparable<? extends T>> {

  private T t;

  public PersonLooselyCoupled(T t) {
    this.t = t;
  }

  public T getT() {
    return t;
  }

  @Override
  public String toString() {
    return "PersonLooselyCoupled{" +
        "t=" + t +
        '}';
  }
}
