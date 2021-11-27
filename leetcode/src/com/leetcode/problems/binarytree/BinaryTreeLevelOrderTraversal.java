package com.leetcode.problems.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层序遍历
 * leetcode:102
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> orderResult = new LinkedList<>();
        order(root, orderResult, 0);

        return orderResult;
    }

    private void order(TreeNode root, List<List<Integer>> result, Integer upLevel) {
        if (null == root) {
            return;
        }
        Integer currentLevel = upLevel + 1;
        List<Integer> levelValue = new LinkedList<>();
        if (result.size() < currentLevel) {
            result.add(levelValue);
        }

        result.get(currentLevel - 1).add(root.val);
        order(root.left, result, currentLevel);
        order(root.right, result, currentLevel);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean test001() {
        /**
         * 用例
         *      5
         *     / \
         *   4    6
         *       / \
         *      3   7
         *
         */
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        List<List<Integer>> result = levelOrder(node1);

        return true;
    }
}
