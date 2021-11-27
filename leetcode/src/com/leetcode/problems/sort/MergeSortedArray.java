package com.leetcode.problems.sort;

/**
 * 88. 合并两个有序数组
 *
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 */
public class MergeSortedArray {
    // 直接合并后排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m, j = 0; i < m + n && j < n; i++, j++) {
            nums1[i] = nums2[j];
        }

        // Arrays.sort(nums1);
        quickSort(nums1, 0, m + n -1);
    }

    private void quickSort(int[] nums, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        // 保留入参头和尾， 递归时用
        int low = lowIndex;
        int high = highIndex;

        int base = nums[low];
        while (low < high) {
            while (low < high) {
                if (nums[high] > base) {
                    high --;
                } else {
                    nums[low] = nums[high];
                    low++;
                    break;// 跳出
                }
            }

            while (low < high) {
                if (nums[low] < base) {
                    low++;
                } else {
                    nums[high] = nums[low];
                    high--;
                    break; // 跳出
                }
            }
        }
        nums[low] = base;
        quickSort(nums, lowIndex, low - 1);
        quickSort(nums, high + 1, highIndex);

    }
}
