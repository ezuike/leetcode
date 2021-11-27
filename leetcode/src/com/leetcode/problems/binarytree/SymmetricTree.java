package com.leetcode.problems.binarytree;

/**
 * 对称二叉树
 * leet code:101
 */
public class SymmetricTree {

    /**
     * 我们可以实现这样一个递归函数，通过「同步移动」两个指针的方法来遍历这棵树，pp 指针和 qq 指针一开始都指向这棵树的根，随后 pp 右移时，
     * qq 左移，pp 左移时，qq 右移。每次检查当前 pp 和 qq 节点的值是否相等，如果相等再判断左右子树是否对称。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        return check(root.left, root.right);
    }

    private boolean check(TreeNode tree1, TreeNode tree2) {
        if (null == tree1 && null == tree2) {
            return true;
        }
        if (null == tree1 || null == tree2) {
            return false;
        }
        // 递归：当前值相等，且树一的左子树与树二的右子树相等，且数一的右子树与树二的左子树相等。
        return tree1.val == tree2.val
                && check(tree1.left, tree2.right)
                && check(tree1.right, tree2.left);
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
