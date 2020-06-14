package com.kv.concurrency.countdown;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class Worker implements Callable<List<Integer>> {

  private CountDownLatch latch;
  private List<Integer> work;

  public Worker(CountDownLatch latch, List<Integer> work) {
    this.latch = latch;
    this.work = work;
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
  public List<Integer> call() throws Exception {
    List<Integer> compute = this.compute(this.work);
    this.latch.countDown();
    return compute;
  }
}
