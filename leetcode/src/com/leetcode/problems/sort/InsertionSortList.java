package com.leetcode.problems.sort;

/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 */
public class InsertionSortList {
    // 插入排序
    public ListNode insertionSortList(ListNode head) {
        ListNode curNode = head;

        // 排序后链表-header, new 一个新节点，方便处理
        ListNode sortedHead = new ListNode(Integer.MIN_VALUE);

        while (null != curNode) {
            // 找到插入前一个节点
            ListNode pre = sortedHead;
            while (null != pre.next && pre.next.val < curNode.val) {
                pre = pre.next;
            }

            ListNode tempCur = curNode;
            curNode = curNode.next;

            // 插入， 这样，新节点永远插入在pre Node的后面。
            ListNode preNext = pre.next;
            pre.next = tempCur;
            tempCur.next = preNext;
        }

        return sortedHead.next;
    }

    public ListNode insertionSortList1(ListNode head) {
        ListNode curNode = head;
        ListNode sortedHead = null;
        while (null != curNode) {
            if (sortedHead == null) {
                sortedHead = curNode;
                curNode = curNode.next;
                sortedHead.next = null;
            } else {
                ListNode tempHead = sortedHead;
                ListNode tempCurNode = curNode;
                curNode = curNode.next;
                if (tempCurNode.val < tempHead.val) {
                    tempCurNode.next = sortedHead;
                    sortedHead = tempCurNode;
                    continue;
                }

                while (null != tempHead) {
                    if (null != tempHead.next) {
                        if (tempHead.next.val < tempCurNode.val) {
                            tempHead = tempHead.next;
                        } else {
                            ListNode tail = tempHead.next;
                            tempHead.next = tempCurNode;
                            tempCurNode.next = tail;
                            break;
                        }
                    } else {
                        tempHead.next = tempCurNode;
                        tempCurNode.next = null;
                        break;
                    }
                }
            }
        }

        return sortedHead;
    }

    public  void test001() {
        ListNode header = new ListNode(9);
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode five = new ListNode(0);

        header.next = one;
        one.next = two;
        two.next = three;
        three.next = five;

        ListNode result = insertionSortList(header);

        while(null != result) {
            System.out.print(result.val);
            System.out.print(",");
            result = result.next;
        }
        System.out.println();
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

}
