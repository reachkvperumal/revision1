package com.kv.concurrency.lock.mess;

import java.util.Timer;
import java.util.TimerTask;

/**
 * From Java Puzzlers
 */
public class Worker extends Thread {

  private volatile boolean quittingTime = false;
  private Object lock = new Object(); //without this lock in second synchronized block it will run in a infinite

  @Override
  public void run() {
    while (!quittingTime) {
      working();
      System.out.println("Still working...");
    }
    System.out.println("Coffee is good !");
  }

  private void working() {
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
    }
  }

  synchronized void quit() throws InterruptedException {
    synchronized (lock) { //with this second synchronized block code execution is handled as expected.
      quittingTime = true;
      System.out.println("Calling join");
      join(); // this will release the key next line is never invoked.
      System.out.println("Back from join");
    }
  }

  synchronized void keepWorking() {
    synchronized (lock) {//with this second synchronized block code execution is handled as expected.
      quittingTime = false;
      System.out.println("Keep working");
    }

  }

  public static void main(String[] args) throws InterruptedException {
    Worker worker = new Worker();
    worker.start();

    Timer t = new Timer(true); // this is a daemon thread will keep running forever.
    t.schedule(new TimerTask() {
      @Override
      public void run() {
        worker.keepWorking();
      }
    }, 500);
    Thread.sleep(400);
    worker.quit();
  }

}

