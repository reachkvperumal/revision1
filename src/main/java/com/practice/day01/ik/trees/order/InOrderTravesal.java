package com.practice.day01.ik.trees.order;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class InOrderTravesal {
    private static class TreeNode {
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static void inOrderRecursive(TreeNode root) {
        if (root == null)
            return;
        inOrderRecursive(root.left_ptr);
        System.out.print(root.val + " ");
        inOrderRecursive(root.right_ptr);
    }

    static int[] inOrderIterative(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> result = new ArrayDeque<>();

        TreeNode current = root;
        while (!deque.isEmpty() || current != null) {
            if (current != null) {
                deque.offerFirst(current);
                current = current.left_ptr;
            } else {
                current = deque.pollFirst();
                result.offer(current);
                current = current.right_ptr;
            }
        }
        return result.stream().map(o -> o.val).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TreeNode x = new TreeNode(15);
        x.left_ptr = new TreeNode(10);
        x.right_ptr = new TreeNode(20);
        x.left_ptr.left_ptr = new TreeNode(8);
        x.left_ptr.right_ptr = new TreeNode(12);
        x.right_ptr.left_ptr = new TreeNode(16);
        x.right_ptr.right_ptr = new TreeNode(25);
        x.right_ptr.right_ptr.right_ptr = new TreeNode((35));

        //8 10 12 15 16 20 25 35
        System.out.println(Arrays.toString(inOrderIterative(x)));
        inOrderRecursive(x);
    }
}
