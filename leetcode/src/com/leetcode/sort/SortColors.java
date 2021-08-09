package com.leetcode.sort;

import java.util.Arrays;

/**
 * 75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *
 *
 * 思路：第一次遍历将0放在头部，第二次遍历，将2 放在尾部，中间必然是1
 */
public class SortColors {


    public void sortColors(int[] nums) {

        // TODO
    }

    // 冒泡排序 时间复杂度：O(n2)
    private void bubbleSorting(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                // 交换位置
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    // 选择排序 时间复杂度：O(n2)
    private void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;

            for (int j= i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }

            if (i != min) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }

    // 快速排序
    private void quickSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        quickSort(nums, low, high);
    }

    private void quickSort(int[] nums, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int low = lowIndex;
        int high = highIndex;// 保留入参
        int base = nums[low];// 保留入参
        while (low < high) {
            // 当右侧nums[high] > base, high--左移， 否则将nums[high] 赋值给nums[low],low++
            while (low < high) {
                if (nums[high] > base) {
                    high--;
                } else {
                    nums[low] = nums[high];
                    low++;
                    break;
                }
            }
            // 当左侧nums[low] < base ,low++右移动，否则将nums[low] 赋值给nums[high],high--
            while (low < high) {
                if (nums[low] < base ) {
                    low++;
                } else {
                    nums[high] = nums[low];
                    high--;
                    break;
                }
            }
        }
        nums[low] = base;
        quickSort(nums,lowIndex, low - 1 );
        quickSort(nums,high + 1, highIndex);
    }


    public void test001() {
        int[] nums = new int[] {2,1,0,1,1,1,0,0,2,2,0,2};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }
}
