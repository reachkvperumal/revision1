package com.practice.day01.ik.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SumOfPath {
    private static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    private static class Count {
        private TreeNode node;
        private int count;

        public Count(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        }
    }

    static List<Integer> sum(TreeNode root, int k) {
        if (root == null)
            return null;

        Deque<Count> deque = new ArrayDeque<>();


        return null;
    }
}
