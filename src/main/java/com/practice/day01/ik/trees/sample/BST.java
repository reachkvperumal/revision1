package com.practice.day01.ik.trees.sample;

public class BST {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static int minValue = Integer.MIN_VALUE;

    static boolean isBST(TreeNode root) {
        if (root == null)
            return true;

        if (!isBST(root.left))
            return false;

        if (root.val < minValue)
            return false;

        minValue = root.val;
        return isBST(root.right);
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

        System.out.println(isBST(x));

    }
}
