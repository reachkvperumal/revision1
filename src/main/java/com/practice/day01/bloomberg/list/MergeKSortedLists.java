package com.practice.day01.bloomberg.list;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        int n = lists.length;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < n; i++) {
            if (lists[i] != null)
                pq.offer(lists[i]);
        }

        ListNode head = null;
        ListNode last = null;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();

            if (head == null)
                head = last = min;
            else {
                last.next = min;
                last = min;
            }

            if (min.next != null)
                pq.offer(min.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode one = new ListNode(1);
        one.next = new ListNode(4);
        one.next.next = new ListNode(5);
        one.next.next.next = null;
        lists[0] = one;

        ListNode two = new ListNode(1);
        two.next = new ListNode(3);
        two.next.next = new ListNode(4);
        two.next.next.next = null;
        lists[1] = one;

        ListNode three = new ListNode(2);
        three.next = new ListNode(6);
        three.next.next = null;
        lists[2] = three;

        ListNode result = mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }


    }
}
