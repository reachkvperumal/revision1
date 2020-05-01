package com.practice.day02.generics;


public class Evaluator {

  public static void main(String[] args) {
    Strict<Integer> strict = new Strict<>(75);
    IntegerWrapper wrapper = new IntegerWrapper(76);
    LooselyCoupled<IntegerWrapper> looselyCoupled = new LooselyCoupled<>(wrapper);

    strict.show();
    looselyCoupled.show();
    System.out.println(wrapper.compareTo(strict.getT().intValue()));

  }

}
