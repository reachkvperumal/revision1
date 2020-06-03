package com.kv.concurrency.singleton;

public class DemoSingleton {

  private volatile static DemoSingleton intance;

  private DemoSingleton() {
  }

  public static DemoSingleton getInstance() {
    if (intance == null) {
      synchronized (DemoSingleton.class) {
        if (intance == null) {
          return intance = new DemoSingleton();
        }
      }
    }
    return intance;
  }

}
