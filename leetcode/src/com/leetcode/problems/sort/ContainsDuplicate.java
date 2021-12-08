package com.leetcode.problems.sort;

import com.leetcode.common.AbstractLeetCodeProblemService;
import com.leetcode.dto.LeetCodeProblem;
import com.leetcode.enums.Difficulty;
import com.leetcode.enums.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate extends AbstractLeetCodeProblemService {
    public ContainsDuplicate() {
        LeetCodeProblem leetCodeProblem = new LeetCodeProblem();
        leetCodeProblem.setNumber(217L);
        leetCodeProblem.setTitle("存在重复元素");
        leetCodeProblem.setDifficulty(Difficulty.EASY.getCode());


        leetCodeProblem.setSolvingIdeas("");
        leetCodeProblem.setStatus(Status.RESOLVED.getCode());

        super.setLeetCodeProblem(leetCodeProblem);
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            if (null != map.get(nums[i])) {
                return true;
            } else {
                map.put(nums[i], nums[i]);
            }
        }
        return false;
    }

    @Override
    public void test() {
        test001();
    }

    private void test001() {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};

        System.out.println("[test001]output:" + containsDuplicate(nums) + ", expected answer:true");
    }
}
