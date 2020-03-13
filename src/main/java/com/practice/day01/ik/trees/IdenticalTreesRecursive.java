package com.practice.day01.ik.trees;

public class IdenticalTreesRecursive {

    private static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    static boolean isIdentical(Node x, Node y) {
        if (x == null && y == null)
            return true;

        return ((x != null && y != null) && (x.key == y.key) &&
                isIdentical(x.left, y.left) && isIdentical(x.right, y.right));
    }

    public static void main(String[] args) {
        // construct first tree
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);
        x.right.right.right = new Node(35);
        // construct second tree
        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);
        y.right.right.right = new Node(35);


        if (isIdentical(x, y)) {
            System.out.print("Given binary Trees are identical");
        } else {
            System.out.print("Given binary Trees are not identical");
        }
    }

}
