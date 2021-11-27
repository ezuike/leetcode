package com.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 148. 排序链表
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]

 * 进阶：
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode i = head;
        while(null != i) {
            list.add(i);
            i = i.next;
        }
        quickSort(list, 0, list.size() - 1);
        return head;
    }

    // 转数组，快速排序， 超出时间限制
    public ListNode sortList2(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode i = head;
        while(null != i) {
            list.add(i);
            i = i.next;
        }
        quickSort(list, 0, list.size() - 1);
        return head;
    }

    private void quickSort(List<ListNode> nodes, int low, int high) {
        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        int base = nodes.get(i).val;
        while (i < j) {
            // 高位
            while (i < j) {
                ListNode current = nodes.get(j);
                if (base > current.val) {
                    // 赋值
                    nodes.get(i).val = current.val;
                    i++;
                    break; // 容易遗忘
                } else {
                    j--;
                }
            }
            // 低位
            while (i < j) {
                ListNode current = nodes.get(i);
                if (current.val < base ) {
                    i++;
                } else {
                    // 交换;
                    nodes.get(j).val = current.val;
                    j--;
                    break;// 容易遗忘
                }
            }
        }

        nodes.get(i).val = base;
        quickSort(nodes, low , i - 1);
        quickSort(nodes, j + 1, high);
    }


    // 选择排序O(n2) ，超出时间限制
    public ListNode sortList1(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode i = head;
        while (null != i) {
            ListNode j = i.next;
            ListNode min = i;
            while (null != j) {
                if (j.val < min.val) {
                    min = j;
                }
                j = j.next;
            }
            // 交换数据
            if (i != min) {
                int temp = i.val;
                i.val = min.val;
                min.val = temp;
            }

            i = i.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void test001() {
        ListNode a1 = new ListNode(9);
        ListNode a2 = new ListNode(-1);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(11);
        ListNode a5 = new ListNode(3);
        ListNode a6 = new ListNode(2);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        ListNode result = sortList(a1);

        // 输出
        while(null != result) {
            System.out.print(result.val + ",");
            result = result.next;
        }
        System.out.println();
    }


}
