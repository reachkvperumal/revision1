package com.practice.day01.ik.trees.sample;

import java.util.concurrent.atomic.AtomicInteger;

public class UnivalTree {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static boolean isUnivalHelper(TreeNode root, AtomicInteger counter) {

        if (root == null)
            return true;

        boolean left = isUnivalHelper(root.left, counter);
        boolean right = isUnivalHelper(root.right, counter);

        if (left && right) {
            boolean moveUp = root.left == null || root.left.val == root.val ? true : false;
            moveUp = moveUp && (root.right == null || root.right.val == root.val) ? true : false;
            if (moveUp) {
                counter.incrementAndGet();
                return true;
            }
        }
        return false;
    }

    static int isUniVal(TreeNode root) {
        if (root == null)
            return 0;
        AtomicInteger counter = new AtomicInteger(0);
        isUnivalHelper(root, counter);
        return counter.get();

    }

    public static void main(String[] args) {
        TreeNode x = new TreeNode(1);
        x.left = new TreeNode(1);
        x.right = new TreeNode(1);
        x.left.left = new TreeNode(1);
        x.left.right = new TreeNode(1);
        x.right.left = new TreeNode(1);
        x.right.right = new TreeNode(1);
        x.right.right.right = new TreeNode(3);

        System.out.println(isUniVal(x));
    }

}
