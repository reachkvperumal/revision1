package com.practice.day01.ik.trees.sample;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PostOrderTravesal {

    private static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    static int[] postorderTraversal(TreeNode root) {

        if (root == null)
            return null;

        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> result = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            result.offerFirst(poll);
            if (poll.left != null)
                deque.offerFirst(poll.left);
            if (poll.right != null)
                deque.offerFirst(poll.right);
        }

        return result.stream().map(o -> o.key).mapToInt(Integer::intValue).toArray();
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

        System.out.println(Arrays.toString(postorderTraversal(x)));


    }

}
