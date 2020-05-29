package com.kv.concurrency;


public class ProducerConsumer {

  private static Object lock = new Object();

  private static int[] buffer;
  private static int count;

  private static class Producer {

    void produce() throws InterruptedException {
      synchronized (lock) {
        if (isFull(buffer)) {
          lock.wait();
        }
        buffer[count++] = 1;
        lock.notify();
      }
    }
  }

  private static class Consumer {

    void consume() throws InterruptedException {
      synchronized (lock) {
        if (isEmpty(buffer)) {
          lock.wait();
        }
        buffer[--count] = 0;
        lock.notify();
      }
    }
  }

  static boolean isFull(int[] buffer) {
    return count == buffer.length;
  }

  static boolean isEmpty(int[] buffer) {
    return count == 0;
  }

  public static void main(String[] args) throws InterruptedException {

    buffer = new int[10];
    count = 0;
    Producer producer = new Producer();
    Consumer consumer = new Consumer();

    Runnable produceTask = () -> {

      for (int i = 0; i < 50; i++) {
        try {
          producer.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    Runnable consumeTask = () -> {
      for (int i = 0; i < 45; i++) {
        try {
          consumer.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    Thread producerThread = new Thread(produceTask, "PRODUCER");
    producerThread.start();
    Thread consumerThread = new Thread(consumeTask, "CONSUMER");
    consumerThread.start();

    producerThread.join();
    consumerThread.join();

    System.out.println("Data in buffer: " + count);

  }
}
