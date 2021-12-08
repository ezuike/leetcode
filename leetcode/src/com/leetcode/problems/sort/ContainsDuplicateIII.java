package com.leetcode.problems.sort;

import com.leetcode.common.AbstractLeetCodeProblemService;
import com.leetcode.dto.LeetCodeProblem;
import com.leetcode.enums.Difficulty;
import com.leetcode.enums.Status;

/**
 * 220. 存在重复元素 III
 *
 */
public class ContainsDuplicateIII extends AbstractLeetCodeProblemService {

    public ContainsDuplicateIII() {
        LeetCodeProblem leetCodeProblem = new LeetCodeProblem();
        leetCodeProblem.setNumber(217L);
        leetCodeProblem.setTitle("存在重复元素");
        leetCodeProblem.setDifficulty(Difficulty.EASY.getCode());


        leetCodeProblem.setSolvingIdeas("");
        leetCodeProblem.setStatus(Status.RESOLVED.getCode());

        super.setLeetCodeProblem(leetCodeProblem);
    }
    @Override
    public void test() {

    }
}
