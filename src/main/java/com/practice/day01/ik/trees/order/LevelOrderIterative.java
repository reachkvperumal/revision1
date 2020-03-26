package com.practice.day01.ik.trees.order;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderIterative {

    private static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int key) {
            this.val = key;
        }
    }

    static List<List<Integer>> levelOrder(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(node);
        int level = 0;
        while (!deque.isEmpty()) {
            result.add(new ArrayList<>());
            int dSize = deque.size();
            for (int i = 0; i < dSize; i++) {
                TreeNode current = deque.remove();
                result.get(level).add(current.val);
                if (current.left != null)
                    deque.add(current.left);
                if (current.right != null)
                    deque.add(current.right);
            }
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(levelOrder(node));
    }

}
