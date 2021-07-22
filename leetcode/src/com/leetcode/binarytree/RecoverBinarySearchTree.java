package com.leetcode.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * 题目：给你二叉搜索树的根节点 root ，该树中的【两个节点】被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        Integer[] values = new Integer[1000];
        List<TreeNode> treeNodes = new LinkedList<>();



    }

    void middleList(TreeNode root, List<Integer> values , List<TreeNode> treeNodes) {
        if (null == root) {
            return;
        }


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
