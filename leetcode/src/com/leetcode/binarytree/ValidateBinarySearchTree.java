package com.leetcode.binarytree;

import com.sun.tools.javac.util.Assert;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 验证二叉搜索树
 * leet code:98
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidateBinarySearchTree {

    // 先中序遍历，得到排序列表。校验列表是否从小到大
    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }

        // 遍历到list里面进行校验
        List<Integer> values = new LinkedList<>();
        middleList(root, values);

        Iterator<Integer> it = values.iterator();
        Integer last = it.next();
        while (it.hasNext()) {
            Integer current = it.next();
            if (last >= current) {
                return false;
            }
            last = current;
        }

        return true;
    }

    // 中序遍历
    private void middleList(TreeNode root, List<Integer> values) {
        if (null == root) {
            return;
        }

        middleList(root.left, values);
        if (values.size() > 0 && values.get(values.size() -1) >= root.val)
        values.add(root.val);
        middleList(root.right, values);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
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
         * 容易出错用例
         *      5
         *     / \
         *   4    6
         *       / \
         *      3   7
         *
         */
        ValidateBinarySearchTree.TreeNode node1 = new ValidateBinarySearchTree.TreeNode(5);
        ValidateBinarySearchTree.TreeNode node2 = new ValidateBinarySearchTree.TreeNode(4);
        ValidateBinarySearchTree.TreeNode node3 = new ValidateBinarySearchTree.TreeNode(6);
        ValidateBinarySearchTree.TreeNode node4 = new ValidateBinarySearchTree.TreeNode(3);
        ValidateBinarySearchTree.TreeNode node5 = new ValidateBinarySearchTree.TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        return isValidBST(node1) == false;
    }
}
