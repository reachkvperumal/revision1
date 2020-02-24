package com.practice.day01.practice;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Bikes.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Bike {
    String model();

    double price();
}
