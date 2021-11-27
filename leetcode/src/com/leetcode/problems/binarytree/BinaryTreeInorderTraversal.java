package com.leetcode.problems.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中序遍历
 * leet code：94
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new LinkedList<>();
        inorderTraversal(root, values);
        return values;
    }

    private void inorderTraversal(TreeNode root, List<Integer> values) {
        if (null == root) {
            return;
        }
        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
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
}
