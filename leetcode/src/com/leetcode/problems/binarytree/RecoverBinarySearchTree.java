package com.leetcode.problems.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * 题目：给你二叉搜索树的根节点 root ，该树中的【两个节点】被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 */
public class RecoverBinarySearchTree {
    /**
     * 解题思路
     * 正确顺序：1 2 3 4 5 6 7
     * 正确顺序：1 *3 *2 4 5 6 7
     * 错误顺序：*7 2 3 4 5 6 *1
     * 错误顺序：1 *6 3 4 5 *2 7
     * 错误顺序：1 *7 3 4 5 6 *2
     * 1.先中序遍历，得到节点列表
     * 2.第一次循环，nodes[i].val < nodes[i+1],不满足这个条件的nodes[i]必然是第一个错误节点a
     * 3.第二次循环，nodes[j].val < a < nodes[j+1]，那么nodes[j] 就是第二个错误节点b，
     * 如果没找到，那么最后一个nodes[nodes.length -1] 就是第二个错误节点b，
     * 4.交换a和b的值。
     */
    public void recoverTree(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();

        // 中序列遍历
        middleList(root, treeNodes);

        // 正确顺序：1 2 3 4 5 6 7
        // 正确顺序：1 *3 *2 4 5 6 7
        // 错误顺序：*7 2 3 4 5 6 *1
        // 错误顺序：1 *6 3 4 5 *2 7
        // 错误顺序：1 *7 3 4 5 6 *2
        // 找到第一个不符合要求的节点，第一个>后面数字的必然是errorcode
        TreeNode errorNodeOne = null;
        for (int i = 0; i < treeNodes.size() - 1; i++) {
            if (treeNodes.get(i).val > treeNodes.get(i + 1).val) {
                errorNodeOne = treeNodes.get(i);
                break;
            }
        }
        if (null == errorNodeOne) {
            return;
        }

        // 找个第二个errorNode， a < b < c，a就是第二个错误节点
        TreeNode errorNodeTwo = null;
        for (int i = 0; i < treeNodes.size() - 1; i++) {
            if (treeNodes.get(i).val < errorNodeOne.val && errorNodeOne.val < treeNodes.get(i + 1).val) {
                errorNodeTwo = treeNodes.get(i);
                break;
            }
        }
        // 第二个错误节点必然是最后一个（前提是必然存在第二个错误节点）
        if (null == errorNodeTwo) {
            errorNodeTwo = treeNodes.get(treeNodes.size() - 1);
        }

        // 交换数据
        int temp = errorNodeOne.val;
        errorNodeOne.val = errorNodeTwo.val;
        errorNodeTwo.val = temp;
    }

    void middleList(TreeNode root, List<TreeNode> treeNodes) {
        if (null == root) {
            return;
        }

        middleList(root.left, treeNodes);
        treeNodes.add(root);
        middleList(root.right, treeNodes);
    }

    public void test001() {
        /**
         * 用例
         *      3
         *     / \
         *   1    4
         *       / \
         *      2   5
         * 1 3 2 4 7
         */
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        recoverTree(node1);
        System.out.println(node1.val);
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
