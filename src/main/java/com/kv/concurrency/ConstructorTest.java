package com.kv.concurrency;

public class ConstructorTest {

  static {
    initialize();
  }

  private static int sum;

  public static int getSum() {
    System.out.println(sum);
    System.out.println(initialized);
    initialize();
    return sum;
  }

  private static boolean initialized = false;

  private static void initialize() {
    if (!initialized) {
      for (int i = 0; i < 100; i++) {
        sum += i;
      }
      initialized = true;
    }
  }

  public static void main(String[] args) {
    System.out.println(getSum());
  }
}
