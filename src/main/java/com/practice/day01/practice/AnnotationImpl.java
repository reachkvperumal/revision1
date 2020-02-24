package com.practice.day01.practice;

import java.util.Arrays;

@Brand(brand = {"Ferrari", "Acura"})
@Brand(brand = {"AMG, GL450, C80"})
@Brand(brand = {"Porsche", "Bugati"})
@Bike(model = "Yamaha", price = 10000.00)
@Bike(model = "Honda", price = 12000.00)
@Bike(model = "Aprila", price = 11000.00)
@Bike(model = "Ducati", price = 35000.00)
public class AnnotationImpl {
    public static void main(String[] args) {
        Arrays.stream(AnnotationImpl.class.getAnnotationsByType(Brand.class)).forEach(o -> System.out.println(Arrays.toString(o.brand())));
        Arrays.stream(AnnotationImpl.class.getAnnotationsByType(Bike.class)).forEach(o -> System.out.printf("Model : %s Price: %.2f%n", o.model(), o.price()));
    }
}
