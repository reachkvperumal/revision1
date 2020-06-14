package com.kv.concurrency.countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.time.StopWatch;

public class ProcessCountDownLatch {

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

  public static void main(String[] args) {
    StopWatch stopWatch = new StopWatch("Count Down Latch");
    stopWatch.start();
    int parties = Runtime.getRuntime().availableProcessors();
    int n = 1_000_000_99;
    CountDownLatch latch = new CountDownLatch(parties);
    ExecutorService service = Executors.newFixedThreadPool(parties);

    List<Future<List<Integer>>> submit = new ArrayList<>();

    for (List<Integer> work : split(n, parties)) {
      submit.add(service.submit(new Worker(latch, work)));
    }
    try {
      latch.await(500, TimeUnit.MILLISECONDS);
      service.shutdown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    stopWatch.stop();
    System.out.println("-------------------");
    System.out.println(stopWatch.getTime(TimeUnit.MILLISECONDS));

    System.out.println("-------------------");
  }
}
