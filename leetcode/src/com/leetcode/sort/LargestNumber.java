package com.leetcode.sort;

import com.leetcode.common.LeetCodeProblem;
import com.leetcode.enums.ResolveType;

import java.util.Arrays;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 */
public class LargestNumber implements LeetCodeProblem {

    /**
     *
     * 解题思想
     * 要解决这个题目是有一个技巧的，就是排序的条件和正常的不太一样。我们看给一个数组进行排序的时候，只需要比较两个元素 (假设 x 和 y 是数组的任意两个元素) 的大小即可：
     *
     * 只要 x > y，那么降序排列的话 y 就应该排在 x 的后面
     * 只要 x < y，那么降序排列的话 x 就应该排在 y 的后面
     * 对于这道题目，假设 x 和 y 是数组中任意两个元素，那么 x 是需要排在 y 的前面还是后面呢？这个取决于 xy 和 yx 哪个大哪个小：
     *
     * 如果 xy > yx，那么 y 应该排在 x 的后面
     * 如果 xy < yx，那么 x 应该排在 y 的后面
     * 比如，x = 30， y = 3，那么 xy = 303，yx = 330，因为 xy < yx ，所以 30 应该在排在 3 的后面，这样就可以得到最大值
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(stringNums, (x, y) -> {
            String xy = x + y;
            String yx = y + x;
            // 如果xy < yx(), y要排在x前面(x > y)，应该返回 1，
            // 如果xy > yx, x要排在y前面(x < y)，应该返回 -1
            return yx.compareTo(xy);// 若yx < xy,返回<0，x排在y前面; 若yx > xy，返回>0, y排在x前面
        });

        // 处理全是0的特殊场景，如0000
        if (stringNums[0].equals("0")) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String num : stringNums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    private void test001() {
        int[] nums = new int[]{3, 30, 34, 5, 9};

        System.out.println("[test001]output:" + largestNumber(nums) + ", expected answer:9534330");
    }

    /**
     * 特殊用例
     */
    private void test002() {
        int[] nums = new int[]{0, 0, 0, 0, 0};

        System.out.println("[test002]output:" + largestNumber(nums) + ", expected answer:0");
    }

    @Override
    public String getResolveType() {
        return ResolveType.RESOLVED_BY_ANSWER.getCode();
    }

    @Override
    public void test() {
        test001();
        test002();
    }
}
