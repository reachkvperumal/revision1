package com.practice.day01.ik.trees;

public class DiameterBT {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int ans = 0;

    static int helper(TreeNode root) {
        if (root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }

    static int diameter(TreeNode root) {
        ans = 1;
        helper(root);
        return ans - 1;
    }

    public static void main(String[] args) {
        TreeNode x = new TreeNode(1);
        x.left = new TreeNode(2);
        x.right = new TreeNode(3);
        x.left.left = new TreeNode(4);
        x.left.right = new TreeNode(5);
        /*x.right.left = new TreeNode(16);
        x.right.right = new TreeNode(25);
        x.right.right.right = new TreeNode(35);*/

        System.out.println(diameter(x));
    }
}
