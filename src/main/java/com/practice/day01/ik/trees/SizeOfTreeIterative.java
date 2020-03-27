package com.practice.day01.ik.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class SizeOfTreeIterative {
    private static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private static int height(Node root) {
        if (root == null)
            return 0;

        Deque<Node> deque = new ArrayDeque<>();
        int count = 0;
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                Node current = deque.poll();
                if (current.left != null)
                    deque.offer(current.left);
                if (current.right != null)
                    deque.offer(current.right);
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);
        x.right.right.right = new Node(35);

        System.out.println(height(x));

        Node y = new Node(1);
        y.left = new Node(2);
        y.right = new Node(3);
        y.left.left = new Node(4);
        y.left.right = new Node(5);
        System.out.println(height(y));
    }
}
