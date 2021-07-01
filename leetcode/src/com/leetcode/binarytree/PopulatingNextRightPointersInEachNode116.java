package com.leetcode.binarytree;
/**
 * 填充每个节点的下一个右侧节点指针
 * leetcode 116
 * 注意点：完美二叉树
 */
public class PopulatingNextRightPointersInEachNode116 {

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
    public Node connect(Node root) {
        if (null == root) {
            return root;
        }

        connect(root.left, root.right);
        return root;
    }


    private void connect(Node left, Node right) {
        if (null == left) {
            return;
        }

        if (null == right) {
            return;
        }

        left.next = right;

        connect(left.left, left.right);
        connect(left.right, right.left);
        connect(right.left, right.right);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

}
