package com.practice.day01.ik.trees.sample;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathOfTree {

    private static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    static List<List<Integer>> allPathsOfABinaryTree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        helper(root, new ArrayList<Integer>(), result);
        return result;
    }

    static void helper(TreeNode root, List<Integer> list, List<List<Integer>> result) {
        if (root.left == null && root.right == null) {
            list.add(root.key);
            result.add(list);
            return;
        }

        List<Integer> left = new ArrayList<>(list);
        left.add(root.key);

        List<Integer> right = new ArrayList<>(list);
        right.add(root.key);

        if (root.left != null)
            helper(root.left, left, result);

        if (root.right != null)
            helper(root.right, right, result);
    }

    public static void main(String[] args) {
        TreeNode x = new TreeNode(1);
        x.left = new TreeNode(2);
        x.right = new TreeNode(3);
        x.left.left = new TreeNode(4);
        x.left.right = new TreeNode(5);
        x.right.left = new TreeNode(6);
        x.right.right = new TreeNode(7);

        System.out.println(allPathsOfABinaryTree(x));
    }
}
