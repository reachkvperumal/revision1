package com.practice.day01.practice;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Brand.Brands.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Brand {

    String[] brand();

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Brands {
        Brand[] value();
    }
}
