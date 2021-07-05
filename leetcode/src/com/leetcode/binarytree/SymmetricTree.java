package com.leetcode.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 对称二叉树
 * leet code:101
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        List<Integer> values = new LinkedList<>();
        firstList(root, values);

        for (int i = 0,j = values.size() -1; i < j; i++,j--) {
            if (values.get(i) != values.get(j)) {
                return false;
            }
        }

        return true;
    }

    private void firstList(TreeNode root, List<Integer> values) {
        if (null == root) {
            return;
        }

        values.add(root.val);
        firstList(root.left,values);
        firstList(root.right, values);

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
