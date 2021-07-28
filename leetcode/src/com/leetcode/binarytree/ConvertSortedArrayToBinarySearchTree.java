package com.leetcode.binarytree;

import com.sun.deploy.panel.ITreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * 解题：选择中间位置左边的数字作为根节点，则根节点的下标为 {mid}=({left}+{right})/2 mid=(left+right)/2，此处的除法为整数除法
 *
 * 这种区间分治类的题目，用左闭右闭就好，左闭右开不方便。
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
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
