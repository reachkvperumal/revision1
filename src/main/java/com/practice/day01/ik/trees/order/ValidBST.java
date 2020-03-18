package com.practice.day01.ik.trees.order;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidBST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static boolean isValid(TreeNode root, Integer low, Integer high) {
        if (root == null)
            return true;
        int val = root.val;

        if (low != null && val <= low) return false;
        if (high != null && val >= high) return false;

        if (!isValid(root.left, low, val)) return false;
        if (!isValid(root.right, val, high)) return false;
        return true;
    }

    static boolean isValidBST(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        int inOrder = Integer.MIN_VALUE;

        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.offerFirst(root);
                root = root.left;
            }
            root = deque.pollFirst();

            if (root.val <= inOrder)
                return false;

            inOrder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode x = new TreeNode(15);
        x.left = new TreeNode(10);
        x.right = new TreeNode(20);
        x.left.left = new TreeNode(8);
        x.left.right = new TreeNode(12);
        x.right.left = new TreeNode(16);
        x.right.right = new TreeNode(25);
        x.right.right.right = new TreeNode((35));

        System.out.println(isValidBST(x));
        System.out.println(isValid(x, null, null));
    }
}
