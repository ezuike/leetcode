package com.leetcode.problems.sort;

import com.leetcode.common.AbstractLeetCodeProblemService;
import com.leetcode.common.LeetCodeProblemService;
import com.leetcode.dto.LeetCodeProblem;
import com.leetcode.enums.Difficulty;
import com.leetcode.enums.Status;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * link:https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * <p>
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 提示：
 * 1 <= k <= nums.length <= 104
 * -104<= nums[i] <= 104
 */
public class KthLargestElementInAnArray extends AbstractLeetCodeProblemService {

    public KthLargestElementInAnArray() {
        LeetCodeProblem leetCodeProblem = new LeetCodeProblem();
        leetCodeProblem.setNumber(215L);
        leetCodeProblem.setTitle("数组中的第K个最大元素");
        leetCodeProblem.setDifficulty(Difficulty.EASY.getCode());

        // 先排序(可以自实现排序，也可以用java现成的排序)，然后直接按标记取，如果是升序，则nums[k]，如果是降序，则nums[nums.length = k]
        leetCodeProblem.setSolvingIdeas("");
        leetCodeProblem.setStatus(Status.RESOLVED.getCode());

        super.setLeetCodeProblem(leetCodeProblem);
    }

    @Override
    public void test() {
        test001();
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    private void test001() {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int result = findKthLargest(nums, 4);
        System.out.println("[test001]output:" + result + ", expected answer:4");
    }
}
