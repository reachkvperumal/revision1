package com.kv.concurrency.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheWithReadWrite {

  private Map<Long, String> cache = new HashMap<>();
  private ReadWriteLock rwLock = new ReentrantReadWriteLock();
  private Lock readLock = rwLock.readLock();
  private Lock writeLock = rwLock.writeLock();

  /*
      write are exclusive when a thread is write no other read or write operation can be performed
   */
  public String put(Long key, String value) {
    try {
      writeLock.lock();
      return cache.put(key, value);
    } finally {
      writeLock.unlock();
    }
  }

  /*
      Multiple read operations are free and can be performed in parallel
      Many reads will not be blocked
   */
  public String get(Long key) {
    try {
      readLock.lock();
      return cache.get(key);
    } finally {
      readLock.unlock();
    }
  }

  private class Producer implements Callable<String> {

    private Random random = new Random();

    @Override
    public String call() throws Exception {
      int count = 0;
      while (count++ < 1_000) {
        long key = random.nextInt(1_000);
        put(key, Long.toString(key));
        if (get(key) == null) {
          System.out.printf("Key %d has not been put in the map%n", key);
        }

      }
      System.out.printf("Current Thread: %s Completed %n", Thread.currentThread().getName());
      return "COMPLETED";
    }
  }

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(8);
    CacheWithReadWrite readWrite = new CacheWithReadWrite();
    System.out.println("Adding Values...");
    try {
      for (int i = 0; i < 8; i++) {
        service.submit(readWrite.new Producer());
      }
    } finally {
      service.shutdown();
    }

  }
}
