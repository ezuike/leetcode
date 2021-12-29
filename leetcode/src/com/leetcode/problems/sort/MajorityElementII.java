package com.leetcode.problems.sort;

import com.leetcode.common.AbstractLeetCodeProblemService;
import com.leetcode.dto.LeetCodeProblem;
import com.leetcode.enums.Difficulty;
import com.leetcode.enums.Status;

import java.util.*;

/**
 * 229. 求众数 II
 * 给定一个大小为n的整数数组，找出其中所有出现超过⌊ n/3 ⌋次的元素。
 * <p>
 * 示例1：
 * <p>
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
public class MajorityElementII extends AbstractLeetCodeProblemService {

    public MajorityElementII() {
        LeetCodeProblem leetCodeProblem = new LeetCodeProblem();
        leetCodeProblem.setNumber(229L);
        leetCodeProblem.setTitle("存在重复元素");
        leetCodeProblem.setDifficulty(Difficulty.HARD.getCode());


        leetCodeProblem.setSolvingIdeas("");
        leetCodeProblem.setStatus(Status.UNRESOLVED.getCode());

        super.setLeetCodeProblem(leetCodeProblem);
    }

    public List<Integer> majorityElement1(int[] nums) {
        // hash统计法
        // 时间复杂度：O(n)，其中 n 为数组的长度。
        // 空间复杂度：O(n)，其中 n 为数组的长度，使用哈希表需要开辟额外的空间。
        int threshold = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            Integer count = map.get(num);
            if (null == count) {
                count = 0;
            }

            if (count == threshold) {
                result.add(num);
            }
            map.put(num, ++count);
        }

        return result;
    }

    public List<Integer> majorityElement(int[] nums) {
        // 摩尔计数法
        // 前提：利用反证法推断出满足这样条件的元素最多只有两个
        // 思路：     我们每次检测当前元素是否为第一个选中的元素或者第二个选中的元素。
        //      每次我们发现当前元素与已经选中的两个元素都不相同，则进行抵消一次。
        //      如果存在最终选票大于 0 的元素，我们还需要再次统计已选中元素的次数,检查元素的次数是否大于n/3
        // 时间复杂度：O(n)，其中 n 为数组的长度。
        // 空间复杂度：O(1)，只需要常数个元素用来存储关键元素和统计次数即可。

        int numOne = 0;
        int numTwo = 0;
        int numOneVote = 0;
        int numTwoVote = 0;

        for (int num : nums) {
            if (numOneVote > 0 && numOne == num) {
                numOneVote++;
            } else if (numTwoVote > 0 && numTwo == num) {
                numTwoVote++;
            } else if (numOneVote == 0) {
                numOne = num;
                numOneVote++;
            } else if (numTwoVote == 0) {
                numTwo = num;
                numTwoVote++;
            } else {
                // 抵消
                numOneVote--;
                numTwoVote--;
            }
        }

        // 统计剩下的数量
        numOneVote = 0;
        numTwoVote = 0;
        for (int num : nums) {
            if (numOne == num) {
                numOneVote++;
            } else if (numTwo == num) {
                numTwoVote++;
            }
        }

        // 返回结果
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        if (numOneVote > threshold) {
            result.add(numOne);
        }
        if (numTwoVote > threshold) {
            result.add(numTwo);
        }

        return result;
    }


    @Override
    public void test() {
        test001();
        test002();
        test003();
    }

    private void test001() {
        int[] nums = new int[]{1, 1, 1, 3, 3, 2, 2, 2};

        List<Integer> result = majorityElement(nums);
        System.out.println("[test001]output:" + result + ", expected answer:[1,2]");
    }

    private void test002() {
        int[] nums = new int[]{1};

        List<Integer> result = majorityElement(nums);
        System.out.println("[test002]output:" + result + ", expected answer:[1]");
    }

    private void test003() {
        int[] nums = new int[]{1,2};

        List<Integer> result = majorityElement(nums);
        System.out.println("[test003]output:" + result + ", expected answer:[1,2]");
    }
}
