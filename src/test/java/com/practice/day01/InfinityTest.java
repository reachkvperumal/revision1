package com.practice.day01;

import org.junit.jupiter.api.Test;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfinityTest {

    /*
        Operation         Result
        n ÷ ±Infinity       ±0
     */
    @Test
    public void zeroByInf() {
        assertEquals(0, 0 / Double.POSITIVE_INFINITY);
        assertEquals(0, 1 / Double.POSITIVE_INFINITY);
        assertEquals(-0.0, 0 / Double.NEGATIVE_INFINITY);
        assertEquals(0, 0.0 / 5.0);
    }

    /*
        Operation                   Result
        ±Infinity × ±Infinity       ±Infinity
     */
    @Test
    public void infMultiInf() {
        assertEquals(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY * Double.POSITIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY * Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY * Double.NEGATIVE_INFINITY);
    }

    /*
       Operation                   Result
       ±nonzero ÷ 0                ±Infinity
    */
    @Test
    public void nonZeroDivInf() {
        assertEquals(Double.POSITIVE_INFINITY, 1.0 / 0);
        assertEquals(Double.NEGATIVE_INFINITY, -1.0 / 0);
    }

    /*
       Operation                   Result
       ±Infinity + ±Infinity       ±Infinity
    */
    @Test
    public void infPlusInf() {
        assertEquals(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY + Double.POSITIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY + Double.NEGATIVE_INFINITY);
    }

    /*
       Operation                   Result
       -Infinity - Infinity       -Infinity
    */
    @Test
    public void negativeInfNegativeInf() {
        assertEquals(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY - Double.POSITIVE_INFINITY);
    }

    /*
       Operation                   Result
       ±0 ÷ ±0                      NaN
    */
    @Test
    public void zeroDivZero() {
        assertEquals(NaN, 0.0 / 0.0);
        assertEquals(NaN, -0.0 / -0.0);
    }

    /*
      Operation                   Result
      Infinity - Infinity          NaN
   */
    @Test
    public void InfMinusInf() {
        assertEquals(NaN, Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY);
        assertEquals(NaN, Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY);
    }


    /*
        Operation                   Result
        ±Infinity ÷ ±Infinity       NaN
     */
    @Test
    public void infDivInf() {
        assertEquals(NaN, Double.POSITIVE_INFINITY / Double.POSITIVE_INFINITY);
        assertEquals(NaN, Double.NEGATIVE_INFINITY / Double.POSITIVE_INFINITY);
    }

    /*
     Operation                   Result
     ±Infinity × 0                 NaN
  */
    @Test
    public void InfMultiZero() {
        assertEquals(NaN, Double.POSITIVE_INFINITY * 0);
        assertEquals(NaN, Double.NEGATIVE_INFINITY * 0);
    }


}
