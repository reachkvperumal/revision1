package com.practice.day01;

import org.junit.jupiter.api.Test;

public class FloatingPointTest {

    @Test
    public void test() {
        float d = 10.0f;
        int exponent = Math.getExponent(d);
        System.out.println("EXPONENET: " + exponent);
        System.out.println("MANTISSA: " + Math.pow(2, exponent));
        System.out.println(2.0 / 0.0);
        System.out.println(0.00 == -0.00);
        System.out.println(100.00 == 100.000);
        System.out.println(Math.pow(0, 0));
        System.out.println(Math.pow(7, 0));
        System.out.println(new Float(1f / 256f));

        double d1 = Double.POSITIVE_INFINITY / Double.POSITIVE_INFINITY;
        System.out.println(d1);
        int exponent1 = Math.getExponent(d1);
        System.out.println("Exponent : " + exponent1);
        System.out.println("Mantissa : " + Math.pow(2, exponent1));

    }

}
