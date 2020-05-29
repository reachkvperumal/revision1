package com.kv.concurrency;

public class A {

  private Object key1 = new Object();
  private Object key2 = new Object();

  public void a() {
    synchronized (key1) {
      System.out.printf("[%s] I am in method a() %n", Thread.currentThread().getName());
      b();
    }
  }

  public void b() {
    synchronized (key2) {
      System.out.printf("[%s] I am in method b() %n", Thread.currentThread().getName());
      c();
    }
  }

  public void c() {
    synchronized (key1) {
      System.out.printf("[%s] I am in method c() %n", Thread.currentThread().getName());
    }
  }

}
