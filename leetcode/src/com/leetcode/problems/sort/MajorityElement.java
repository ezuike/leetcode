package com.leetcode.problems.sort;

import com.leetcode.common.AbstractLeetCodeProblemService;
import com.leetcode.dto.LeetCodeProblem;
import com.leetcode.enums.Difficulty;
import com.leetcode.enums.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class MajorityElement extends AbstractLeetCodeProblemService {
    public MajorityElement() {
        LeetCodeProblem leetCodeProblem = new LeetCodeProblem();
        leetCodeProblem.setNumber(169L);
        leetCodeProblem.setTitle("多数元素");
        leetCodeProblem.setDifficulty(Difficulty.EASY.getCode());

        leetCodeProblem.setSolvingIdeas("");
        leetCodeProblem.setStatus(Status.RESOLVED.getCode());

        super.setLeetCodeProblem(leetCodeProblem);
    }

    public int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer sum = map.get(nums[i]);
            sum = null == sum ? 1 : ++sum;
            if (sum > mid) {
                return nums[i];
            }
            map.put(nums[i], sum);
        }
        return 0;
    }

    @Override
    public void test() {

    }
}
