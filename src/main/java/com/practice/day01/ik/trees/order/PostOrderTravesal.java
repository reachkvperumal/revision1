package com.practice.day01.ik.trees.order;

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

    static void postOrderRecursive(TreeNode root) {
        if (root == null)
            return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.key + " ");
    }

    static int[] postorderTraversal(TreeNode root) {

        if (root == null)
            return null;

        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> result = new ArrayDeque<>();
        deque.offer(root);
        // 15, 10, 20, 16, 25,
        while (!deque.isEmpty()) {
            TreeNode poll = deque.pollFirst();
            result.offerFirst(poll);
            if (poll.left != null)
                deque.offerFirst(poll.left);
            if (poll.right != null)
                deque.offerFirst(poll.right);
        }
        //20, 25
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

        System.out.print(Arrays.toString(postorderTraversal(x)));
        int[] i = {8, 12, 10, 16, 35, 25, 20, 15};
        System.out.println();
        postOrderRecursive(x);


    }

}
