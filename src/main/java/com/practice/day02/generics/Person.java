package com.practice.day02.generics;

public class Person implements Comparable<Person> {

  private String name;
  private Integer age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  @Override
  public int compareTo(Person o) {
    return age.compareTo(o.getAge());
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
