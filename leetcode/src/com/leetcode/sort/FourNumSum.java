package com.leetcode.sort;

import java.util.*;

/**
 * 18. 四数之和
 *
 * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？
 * 找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [], target = 0
 * 输出：[]
 *
 *
 * 遗留问题：如何优化时间和空间
 */
public class FourNumSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 先排序
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();
        int length = nums.length;
        int sum = 0;
        int k = 0;
        int h = 0;
        for (int i = 0; i< length; i++) {
            // 去重，节省时间
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < length; j++) {
                // 去重，节省时间
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                k = j + 1;
                h = length - 1;

                while (k < h) {
                    // 去重，节省时间
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }
                    // 不能四个数都这么判断，否则test005过不了
//                    if (h < length - 1 && nums[j] == nums[k + 1]) {
//                        h--;
//                        continue;
//                    }

                    sum = nums[i] + nums[j] + nums[k] + nums[h];

                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        h--;
                    } else {
                        List<Integer> integers = new ArrayList<>(4);
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        integers.add(nums[h]);

                        result.add(integers);
                        k++;
                        h--;
                    }
                }
            }
        }

        return result;
    }


    public void test001() {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;

        List<List<Integer>> result = fourSum(nums, target);

        //[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(result);
    }

    public void test002() {
        int[] nums = new int[]{};
        int target = 0;

        List<List<Integer>> result = fourSum(nums, target);

        //[]
        System.out.println(result);
    }

    public void test003() {
        int[] nums = new int[]{2,2,2,2};
        int target = 8;
        // 利用set集合去重
        List<List<Integer>> result = fourSum(nums, target);

        //[[2,2,2,2]]
        System.out.println(result);
    }

    public void test004() {
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        int target = 0;
        // 利用set集合去重
        List<List<Integer>> result = fourSum(nums, target);

        // [[-2,-1,1,2],[-1,-1,1,1]]
        System.out.println(result);
    }

    public void test005() {
        int[] nums = new int[]{-1,0,-5,-2,-2,-4,0,1,-2};
        int target = -9;
        // 利用set集合去重
        List<List<Integer>> result = fourSum(nums, target);

        // [[-5,-4,-1,1],[-5,-4,0,0],[-5,-2,-2,0],[-4,-2,-2,-1]]
        System.out.println(result);
    }
}
