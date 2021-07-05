package com.leetcode.binarytree;

import java.util.*;

/**
 *
 * leet code:117
 */
public class PopulatingNextRightPointersInEachNodeii {

    public Node connect(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        connect(root, map, 0);
        return root;
    }

    private void connect(Node root, Map<Integer,List<Node>> map, int i) {
       if (null == root) {
           return;
       }
       int index = ++i;
       if (null == map.get(index)) {
           map.put(index, new LinkedList<>());
       }

       // connect
       List<Node> nodes = map.get(index);
       if (nodes.size() > 0) {
           nodes.get(nodes.size() - 1).next = root;
       }
        nodes.add(root);

        connect(root.left, map, index);
        connect(root.right, map, index);
    }

    public static class Node {
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
