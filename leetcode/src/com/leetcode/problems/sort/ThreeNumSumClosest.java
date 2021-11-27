package com.leetcode.problems.sort;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class ThreeNumSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < length; i++) {
            // 节省时间
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 判断
                int current = Math.abs(target - sum);
                if (current < min) {
                    min = current;
                    result = sum;
                }

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                    k--;
                }
            }
        }
        return result;
    }


    public void test001() {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;

        int result = threeSumClosest(nums, target);

        // 2
        System.out.println("result:" + result + ",answer:" + 2);
    }

    public void test002() {
        int[] nums = new int[]{0, 1, 2};
        int target = 3;

        int result = threeSumClosest(nums, target);

        // 2
        System.out.println("result:" + result + ",answer:" + 2);
    }
}
