package com.practice.day01.bloomberg.list;

public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static ListNode[] create() {
        ListNode[] result = new ListNode[2];
        ListNode root = new ListNode(2);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        result[0] = root;

        ListNode root1 = new ListNode(5);
        root1.next = new ListNode(6);
        root1.next.next = new ListNode(4);
        result[1] = root1;
        return result;
    }

    static ListNode add(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode root = new ListNode(0);
        ListNode d = root;
        int sum = 0;

        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }

            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }

            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);

        return root.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = create();
        ListNode result = add(listNodes[0], listNodes[1]);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }

}
