package com.practice.day01.apple.list;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ReverseLinkedList {

  private static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

  }

  static ListNode create(int[] nums) {
    ListNode node = new ListNode(nums[0]);
    AtomicReference<ListNode> reference = new AtomicReference<>();
    reference.set(node);
    AtomicInteger counter = new AtomicInteger(0);
    Arrays.stream(nums).forEach(o -> {
      if (counter.get() > 0) {
        ListNode listNode = reference.get();
        reference.getAndSet(listNode.next = new ListNode(o));
      }
      counter.getAndAdd(1);
    });

    return node;
  }

  static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
      ListNode tmp = current.next;
      current.next = prev;
      prev = current;
      current = tmp;
    }
    return prev;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    ListNode current = create(nums);
    current = reverseList(current);
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }

  }

}
