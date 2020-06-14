package com.kv.concurrency.cyclic;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import org.apache.commons.lang3.time.StopWatch;

public class Worker implements Callable<List<Integer>> {

  private CyclicBarrier cyclicBarrier;
  private List<Integer> input;

  private StopWatch stopWatch;

  public Worker(CyclicBarrier cyclicBarrier, List<Integer> input, StopWatch sw) {
    this.cyclicBarrier = cyclicBarrier;
    this.input = input;
    this.stopWatch = sw;
  }

  private Integer findPrime(int n) {
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

  private List<Integer> compute(List<Integer> payload) {
    return payload.stream().map(this::findPrime).filter(Objects::nonNull).collect(Collectors.toList());
  }

  @Override
  public List<Integer> call() {
    this.stopWatch.start();
    List<Integer> result = compute(this.input);
    try {
      this.cyclicBarrier.await(15, TimeUnit.SECONDS);
      this.stopWatch.stop();
      System.out.println(this.stopWatch.getMessage() + ": " + this.stopWatch.getTime(TimeUnit.SECONDS) + " SECONDS");
    } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
      e.printStackTrace();
    }

    return result;
  }
}
