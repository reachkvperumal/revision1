package com.kv.concurrency;

public class RunningA {

  public static void main(String[] args) throws InterruptedException {
    A a = new A();
    Thread t1 = new Thread(() -> a.a(), "Ferrari");
    t1.start();

    Thread t2 = new Thread(() -> a.b(), "Lamborghini");
    t2.start();

    t1.join();
    t2.join();
  }

}
