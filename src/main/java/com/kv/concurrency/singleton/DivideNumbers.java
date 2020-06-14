package com.kv.concurrency.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DivideNumbers {

  private static Integer isPrime(int n) {

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
      if ((n % i == 0) || n % (i + 2) == 0) {
        return null;
      }
    }
    return n;
  }

  private static List<Integer> compute(List<List<Integer>> payload) {
    return payload.stream().flatMap(obj -> obj.stream()).map(obj -> isPrime(obj)).filter(Objects::nonNull).collect(Collectors.toList());
  }


  public static void main(String[] args) {
    int availableProcessors = Runtime.getRuntime().availableProcessors();
    System.out.println(availableProcessors);
    int size = 1_000_000_99;
    int sizePerProcessor = size / availableProcessors;
    List<List<Integer>> payload = new ArrayList<>();

    int start, end = 0;

    for (int i = 0; i < availableProcessors; i++) {
      start = i == 0 ? 1 : end + 1;
      end = i == availableProcessors - 1 ? size : start + sizePerProcessor - 1;
      payload.add(i, IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList()));
    }

    System.out.println("Completed");
    System.out.println(Runtime.getRuntime().availableProcessors());
  }

}
