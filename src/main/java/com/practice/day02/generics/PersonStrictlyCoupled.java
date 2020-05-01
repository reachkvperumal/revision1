package com.practice.day02.generics;

public class PersonStrictlyCoupled<T extends Object & Comparable<T>> {

  private T t;

  public PersonStrictlyCoupled(T t) {
    this.t = t;
  }

  public T getT() {
    return t;
  }

  @Override
  public String toString() {
    return "PersonStrictlyCoupled{" +
        "t=" + t +
        '}';
  }
}
