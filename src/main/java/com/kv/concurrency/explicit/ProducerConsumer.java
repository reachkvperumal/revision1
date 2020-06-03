package com.kv.concurrency.explicit;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ProducerConsumer {

  private static int[] BUFFER;
  private static int MAX_BUFFER_SIZE;
  private static int ITERATION_COUNT = 50;

  private static Lock lock = new ReentrantLock();
  private static Condition isFull = lock.newCondition();
  private static Condition isEmpty = lock.newCondition();


  private static class Producer implements Callable<String> {

    @Override
    public String call() throws Exception {
      int count = 0;
      while (count++ < ITERATION_COUNT) {
        try {
          lock.lock();
          // int i = 10/0; enable this to validate the timout settings
          while (MAX_BUFFER_SIZE == BUFFER.length) {
            if (!isFull.await(10, TimeUnit.MILLISECONDS)) {
              throw new TimeoutException("Producer time out");
            }
          }
          BUFFER[MAX_BUFFER_SIZE++] = 1;
          isEmpty.signalAll();
        } finally {
          lock.unlock();
        }
      }
      return String.format("Produced %d", (count - 1));
    }
  }

  private static class Consumer implements Callable<String> {

    @Override
    public String call() throws Exception {
      int count = 0;
      while (count++ < ITERATION_COUNT) {
        try {
          lock.lock();
          while (MAX_BUFFER_SIZE == 0) {
            if (!isEmpty.await(10, TimeUnit.SECONDS)) {
              throw new TimeoutException("Consumer timeout!!!");
            }
          }
          BUFFER[--MAX_BUFFER_SIZE] = 0;
          isFull.signalAll();
        } finally {
          lock.unlock();
        }
      }
      return String.format("Consumed %d", (count - 1));
    }
  }

  public static void main(String[] args) throws InterruptedException {
    BUFFER = new int[10];

    List<Producer> producerList = IntStream.range(1, 5).mapToObj(i -> new Producer()).collect(toList());
    List<Consumer> consumerList = IntStream.range(1, 5).mapToObj(i -> new Consumer()).collect(toList());
    List<Callable<String>> producerAndConsumers = new ArrayList<>();
    producerAndConsumers.addAll(producerList);
    producerAndConsumers.addAll(consumerList);
    //# of threads should be more than the producer's count i.e more than 4
    ExecutorService executorService = Executors.newFixedThreadPool(8);

    try {
      List<Future<String>> futures = executorService.invokeAll(producerAndConsumers);
      futures.forEach(future -> {
        try {
          System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
          System.out.println("Exception: " + e.getMessage());
        }
      });

    } finally {
      executorService.shutdown();
    }
  }

}
