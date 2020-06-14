package com.kv.concurrency.cyclic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.time.StopWatch;

public class ProcessCyclicBarrier {

  private static List<List<Integer>> split(int n, int availableProcessors) {
    int sizePerCore = n / availableProcessors;
    int start, end = 0;
    ArrayList<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < availableProcessors; i++) {
      start = i == 0 ? 1 : end + 1;
      end = i == availableProcessors - 1 ? n : start + sizePerCore - 1;
      list.add(IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList()));
    }
    return list;
  }

  private static Integer findPrime(int n) {
    if (n <= 1) {
      return null;
    }
    if (n <= 3) {
      return n;
    }
    if (n % 2 == 0 || n % 3 == 0) {
      return null;
    }
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return null;
      }
    }
    return n;
  }

  public static void main(String[] args) {
    StopWatch stopWatch = new StopWatch("Cyclic Barrier");
    stopWatch.start();
    int n = 1_000_000_99;
    int parties = Runtime.getRuntime().availableProcessors();
    List<Integer> result = new ArrayList<>();
    CyclicBarrier barrier = new CyclicBarrier(parties, () -> {
      stopWatch.stop();
      //System.out.println(stopWatch.getTime(TimeUnit.SECONDS) + " SECONDS");
    });
    ExecutorService service = Executors.newFixedThreadPool(16);

    List<Future<List<Integer>>> futures = new ArrayList<>();

    int i = 1;
    for (List<Integer> items : split(n, parties)) {
      futures.add(service.submit(new Worker(barrier, items, new StopWatch("Worker - " + i))));
      i++;
    }

    futures.forEach(future -> {
      try {
        result.addAll(future.get(/*20, TimeUnit.SECONDS*/));
      } catch (InterruptedException | /*TimeoutException |*/ ExecutionException e) {
        e.printStackTrace();
      }
    });
    System.out.println("-------------------");
    System.out.println(stopWatch.getTime(TimeUnit.SECONDS) + " SECONDS");
    System.out.println("-------------------");
    //System.out.println("Parties Count: "+barrier.getParties());
    System.out.println("Total Count : " + result.size());
    System.out.println("Successfully Completed");
    System.out.println("-------------------");
    service.shutdown();
    stopWatch.reset();
    stopWatch.start();
    List<Integer> direct = new ArrayList<>();
    IntStream.rangeClosed(1, n).boxed().forEach(x -> {
      Integer prime = findPrime(x);
      if (Objects.nonNull(prime)) {
        direct.add(prime);
      }
    });
    stopWatch.stop();

    System.out.println(direct.size());
    System.out.println(stopWatch.getTime(TimeUnit.SECONDS) + " SECONDS");
    System.out.println("-------------------");

  }

}
