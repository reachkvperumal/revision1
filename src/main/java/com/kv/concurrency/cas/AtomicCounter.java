package com.kv.concurrency.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class AtomicCounter {

  private static LongAdder counter = new LongAdder();

  private static class Increment implements Callable<Void> {

    @Override
    public Void call() {
      IntStream.rangeClosed(1, 1_000).forEach(x -> counter.increment());
      return null;
    }
  }

  private static class Decrement implements Callable<Void> {

    @Override
    public Void call() {
      IntStream.rangeClosed(1, 1_000).forEach(x -> counter.decrement());
      return null;
    }
  }

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    List<Future<Void>> futures = new ArrayList<>();

    IntStream.rangeClosed(1, 4).forEach(x -> futures.add(service.submit(new Increment())));
    IntStream.rangeClosed(1, 4).forEach(x -> futures.add(service.submit(new Decrement())));

    futures.stream().forEach(future -> {
      try {
        future.get();
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      } finally {
        service.shutdown();
      }

    });
    System.out.println(counter.sumThenReset());

    byte[] maxArray = new byte[Integer.MAX_VALUE - 2];
    System.out.println(maxArray.length);
  }


}
