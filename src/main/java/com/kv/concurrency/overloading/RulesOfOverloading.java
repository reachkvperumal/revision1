package com.kv.concurrency.overloading;

public class RulesOfOverloading {

  static void method(Object o) {
    System.out.println("Inside method Object");
  }

  /*static void method(Integer integer){
    System.out.println("Inside method Integer");
  }*/

  static void method(int i) {
    System.out.println("Inside method primitive int");
  }

  /*static void method(double d){
    System.out.println("Inside method primitive double");
  }*/

  static void method(Integer i) {
    System.out.println("Inside method Integer");
  }


  static void method(int... i) {
    System.out.println("Inside method varargs int");
  }

  static void method(int i, int j) {
    System.out.println("Inside method 2 arguments as int");
  }

  public static void main(String[] args) {
    //Integer b = 1;
    //method(Integer.valueOf(1));

    //method((byte)1,(byte)2,(byte)2);

    method(1l);

  }

}
