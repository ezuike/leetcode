package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedListToBinarySearchTree {

    // list -> 数组， 数组 -> 平衡二叉搜索树
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (null != head) {
            list.add(head.val);
            head = head.next;
        }

        // list.size() - 1 右侧开区间，防止越界
        return covertToBinarySearchTree(list, 0, list.size() - 1);
    }

    public TreeNode sortedListToBST2(ListNode head) {
        // 计算size，用数组
        int size = 0;
        ListNode node = head;
        while (null != node) {
            ++size;
            node = node.next;
        }
        int[] list = new int[size];
        int i = 0;
        while (null != head) {
            list[i++] = head.val;
            head = head.next;
        }

        // list.size() - 1 右侧开区间，防止越界
        return covertToBinarySearchTree(list, 0, size - 1);
    }

    private TreeNode covertToBinarySearchTree(int[] list, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        TreeNode treeNode = new TreeNode(list[mid]);
        treeNode.left = covertToBinarySearchTree(list, low, mid - 1);
        treeNode.right = covertToBinarySearchTree(list, mid + 1, high);
        return treeNode;
    }

    private TreeNode covertToBinarySearchTree(List<Integer> list, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        TreeNode treeNode = new TreeNode(list.get(mid));
        treeNode.left = covertToBinarySearchTree(list, low, mid - 1);
        treeNode.right = covertToBinarySearchTree(list, mid + 1, high);
        return treeNode;
    }


    /**
     * 测试用例
     */
    public void test001() {
        ListNode header = new ListNode(9);
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode five = new ListNode(0);

        header.next = one;
        one.next = two;
        two.next = three;
        three.next = five;

        TreeNode treeNode = sortedListToBST(header);

        System.out.println(treeNode.val);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
