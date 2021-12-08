package com.leetcode.common;

public interface LeetCodeProblemService {
    /**
     * 解题
     * @return
     */
    String getStatus();

    /**
     * 题目难度
     * @return 难度
     */
    String getDifficulty();

    /**
     * 解题思路
     * @return 解题思路
     */
    String getSolvingIdeas();

    /**
     * 测试用例
     */
    void test();
}
