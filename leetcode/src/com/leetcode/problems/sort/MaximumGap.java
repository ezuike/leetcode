package com.leetcode.problems.sort;

import com.leetcode.common.AbstractLeetCodeProblemService;
import com.leetcode.dto.LeetCodeProblem;
import com.leetcode.enums.Difficulty;
import com.leetcode.enums.Status;

import java.util.Arrays;

/**
 * 164. 最大间距
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 *
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 *
 */
public class MaximumGap extends AbstractLeetCodeProblemService {

    public MaximumGap()   {
        LeetCodeProblem leetCodeProblem = new LeetCodeProblem();
        leetCodeProblem.setNumber(164L);
        leetCodeProblem.setTitle("最大间距");
        leetCodeProblem.setDifficulty(Difficulty.HARD.getCode());


        leetCodeProblem.setSolvingIdeas("");
        // 自己的答案不符合线性要求。
        leetCodeProblem.setStatus(Status.UNRESOLVED.getCode());

        super.setLeetCodeProblem(leetCodeProblem);
    }



    public int maximumGap(int[] nums) {
        // 基数排序O(n)，再取差最大值
        // TODO
        return 1;
    }

    /**
     * 排序方式不满足线性时间要求
     * @param nums
     * @return
     */
    public int maximumGap001(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);

        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i+1] - nums[i];
            if (temp > max) {
                max = temp;
            }
        }

        return max;
    }

    @Override
    public void test() {
        test001();
    }

    private void test001() {
        int[] nums = new int[]{3,6,9,1};

        int result = maximumGap(nums);
        System.out.println("[test001]output:" + result + ", expected answer:3");
    }
}
