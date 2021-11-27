package com.leetcode.problems.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> orderResult = new LinkedList<>();
        order(root, orderResult, 0);

        for (int i = 0, j = orderResult.size() -1; i < j; i ++,j--) {
            List<Integer> temp = orderResult.get(i);
            orderResult.set(i, orderResult.get(j));
            orderResult.set(j, temp);
        }

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
}
