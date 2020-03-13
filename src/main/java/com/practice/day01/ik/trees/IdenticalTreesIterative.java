package com.practice.day01.ik.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class IdenticalTreesIterative {

    private static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private static class Pair<U, V> {
        U first;
        V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public static <U, V> Pair<U, V> of(U first, V second) {
            return new Pair<>(first, second);
        }
    }

    private static boolean isIdentical(Node x, Node y) {
        if (x == null && y == null)
            return true;
        if (x == null)
            return false;
        if (y == null)
            return false;


        Deque<Pair<Node, Node>> deque = new ArrayDeque<>();
        deque.offer(Pair.of(x, y));

        while (!deque.isEmpty()) {
            x = deque.peek().first;
            y = deque.peek().second;

            deque.poll();

            if (x.key != y.key)
                return false;

            if (x.left != null && y.left != null)
                deque.offer(Pair.of(x.left, y.left));
            else if (x.left != null || y.left != null)
                return false;

            if (x.right != null && y.right != null)
                deque.offer(Pair.of(x.right, y.right));
            else if (x.right != null || y.right != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);
        x.right.right.right = new Node((35));
        // construct second tree
        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);

        if (isIdentical(x, y)) {
            System.out.print("Given binary Trees are identical");
        } else {
            System.out.print("Given binary Trees are not identical");
        }
    }

}
