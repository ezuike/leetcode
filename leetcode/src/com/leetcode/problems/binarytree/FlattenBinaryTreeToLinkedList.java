package com.leetcode.problems.binarytree;

/**
 * 二叉树展开为链表
 * leet code 114
 */
public class FlattenBinaryTreeToLinkedList {

    // 先序遍历 ，root -> left -> right
    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }

        // root left 变成右二叉树
        flatten(root.left);
        // root right 变成右二叉树
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 将left插入到 root 和right 直接
        if (null != left) {
            root.right = left;
            root.left = null;

            TreeNode tail = left;
            while(null != tail.right) {
                tail = tail.right;
            }
            tail.right = right;
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
