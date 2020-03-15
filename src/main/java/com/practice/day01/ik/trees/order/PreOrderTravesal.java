package com.practice.day01.ik.trees.order;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PreOrderTravesal {
    private static class TreeNode {
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static void preOrderRecursive(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preOrderRecursive(root.left_ptr);
        preOrderRecursive(root.right_ptr);
    }

    static int[] preOrderIterative(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> result = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode current = deque.pollFirst();
            result.offer(current);
            if (current.right_ptr != null)
                deque.offerFirst(current.right_ptr);

            if (current.left_ptr != null)
                deque.offerFirst(current.left_ptr);
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

        preOrderRecursive(x);
        System.out.println();
        System.out.println(Arrays.toString(preOrderIterative(x)));
    }
}
