package com.leetcode.problems.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Deque<Integer>> tempList = new ArrayList<>();
        // 先序列遍历，****利用双端对列来区分锯齿****
        // Deque是关键
        middleTraversal(root, 0, tempList);

        List<List<Integer>> result = new LinkedList<>();
        for (Deque<Integer> list : tempList) {
            result.add(new LinkedList<>(list));
        }

        return result;

    }

    // 先序遍历并加入数据
    private void middleTraversal(TreeNode root, int i, List<Deque<Integer>> result) {
        if (null == root) {
            return;
        }
        // 加入数据
        Deque<Integer> list;
        if (result.size() < i + 1 ) {
            list = new LinkedList<>();
            result.add(list);
        } else {
            list = result.get(i);
        }
        if (i % 2 == 0) {
            // 偶数层，正序, 从末尾进
            list.addLast(root.val);
        } else {
            // 奇数层，倒序， 从头进（先进先出）
            list.addFirst(root.val);
        }

        middleTraversal(root.left, i+1, result);
        middleTraversal(root.right, i+1, result);
    }

    public void test001() {
        /**
         * 用例
         *      1
         *     / \
         *   2    3
         *  / \  / \
         * 4   56   7
         * 1 3 2 4 7
         */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        List<List<Integer>> result = zigzagLevelOrder(node1);

        for (List<Integer> list : result) {
            System.out.println(list);
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
