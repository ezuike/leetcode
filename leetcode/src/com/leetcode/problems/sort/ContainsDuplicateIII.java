package com.leetcode.problems.sort;

import com.leetcode.common.AbstractLeetCodeProblemService;
import com.leetcode.dto.LeetCodeProblem;
import com.leetcode.enums.Difficulty;
import com.leetcode.enums.Status;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 *给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 *
 * 示例1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 */
public class ContainsDuplicateIII extends AbstractLeetCodeProblemService {

    public ContainsDuplicateIII() {
        LeetCodeProblem leetCodeProblem = new LeetCodeProblem();
        leetCodeProblem.setNumber(217L);
        leetCodeProblem.setTitle("存在重复元素");
        leetCodeProblem.setDifficulty(Difficulty.HARD.getCode());


        leetCodeProblem.setSolvingIdeas("");
        leetCodeProblem.setStatus(Status.UNRESOLVED.getCode());

        super.setLeetCodeProblem(leetCodeProblem);
    }

    // abs(i - j) <= k & abs(nums[i] - nums[j]) <= t
    // 条件转化为
    // abs(i - j) <= k & abs(nums[i] - nums[j]) <= t
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {

            // floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
            //ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    @Override
    public void test() {
        test001();
        test002();
    }

    private void test001() {
        int[] nums = new int[]{-2147483648,2147483647};

        boolean result = containsNearbyAlmostDuplicate(nums,1,1);
        System.out.println("[test001]output:" + result + ", expected answer:false");
    }

    private void test002() {
        int[] nums = new int[]{1,5,9,1,5,9};

        boolean result = containsNearbyAlmostDuplicate(nums,2,3);
        System.out.println("[test002]output:" + result + ", expected answer:false");
    }
}
