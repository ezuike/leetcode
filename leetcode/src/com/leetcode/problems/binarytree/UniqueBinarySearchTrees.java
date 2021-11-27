package com.leetcode.problems.binarytree;

/**
 * leetcode:96. 不同的二叉搜索树
 *
 * 题目：
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * 思路(动态规划)：
 * 给定一个有序序列1⋯n，为了构建出一棵二叉搜索树，我们可以遍历每个数字 i，将该数字作为树根，将 1⋯(i−1) 序列作为左子树，将 (i+1)⋯n 序列作为右子树。
 * 接着我们可以按照同样的方式递归构建左子树和右子树。
 * 在上述构建的过程中，由于根的值不同，因此我们能保证每棵二叉搜索树是唯一的。
 * 由此可见，原问题可以分解成规模较小的两个子问题，且子问题的解可以复用。因此，我们可以想到使用动态规划来求解本题。
 * <p>
 * i
 * /     \
 * 1...i-1   i+1...1
 * <p>
 * 算法：
 * 题目要求是计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
 * G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
 * F(i, n): 以 i 为根、序列长度为 n 的不同二叉搜索树个数 (1≤i≤n)。
 * G(n) 是我们求解需要的函数。G(n) = F(0, n) + F(1,n) + ... + F(n,n),而F(i,n) = G(i-1) * G(n-i),如F(3,n) = G(2) * G(n - 3)
 * <p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] root = new int[n + 1];
        root[0] = 1;
        root[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                root[i] += root[j - 1] * root[i - j];
            }
        }
        return root[n];
    }
}
