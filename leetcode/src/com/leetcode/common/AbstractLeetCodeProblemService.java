package com.leetcode.common;

import com.leetcode.dto.LeetCodeProblem;

public abstract class AbstractLeetCodeProblemService implements LeetCodeProblemService {
    /**
     * 题目对象
     */
    private LeetCodeProblem leetCodeProblem = new LeetCodeProblem();

    @Override
    public String getStatus() {
        return leetCodeProblem.getStatus();
    }

    @Override
    public String getDifficulty() {
        return leetCodeProblem.getDifficulty();
    }

    @Override
    public String getSolvingIdeas() {
        return leetCodeProblem.getSolvingIdeas();
    }

    @Override
    public abstract void test();

    public LeetCodeProblem getLeetCodeProblem() {
        return leetCodeProblem;
    }

    public void setLeetCodeProblem(LeetCodeProblem leetCodeProblem) {
        this.leetCodeProblem = leetCodeProblem;
    }
}
