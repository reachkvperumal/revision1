package com.kv.concurrency.dto;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = -9003105640619991569L;

    private final String name;
    private final int age;
    private final int ranking;

    public Person(String name, int age, int ranking) {
        this.name = name;
        this.age = age;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getRanking() {
        return ranking;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ranking=" + ranking +
                '}';
    }
}
