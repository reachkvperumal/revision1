package com.practice.day02.generics;

public class PersonEvaluator {

  public static void main(String[] args) {
    PersonStrictlyCoupled<Person> kv = new PersonStrictlyCoupled<>(new Person("KV", 44));

    PersonLooselyCoupled<Person> vijay = new PersonLooselyCoupled<>(new Person("Vijay", 32));

    System.out.println(kv);
    System.out.println(vijay);

  }

}
