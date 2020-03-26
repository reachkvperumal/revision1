package com.practice.day01.ik.trees.order;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderRecursive {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key) {
            this.val = key;
        }
    }

    static List<List<Integer>> result = new ArrayList<>();

    static void recursive(TreeNode node, int level) {
        if (result.size() == level)
            result.add(new ArrayList<>());

        result.get(level).add(node.val);
        if (node.left != null)
            recursive(node.left, level + 1);
        if (node.right != null)
            recursive(node.right, level + 1);
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return null;
        recursive(root, 0);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        levelOrder(node);
        System.out.println(result);
    }

}
