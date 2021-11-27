package com.leetcode.problems.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，
 * 该数组需恰好覆盖输入中的所有区间。
 * 示例1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        // 先排序，注意
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] section1, int[] section2) {
                return section1[0] - section2[0];
            }
        });

        // 用List<int[]> 而不用int[][], 控制数组长度，防止出现[0,0]
        List<int[]> result = new ArrayList<>();

        int i = 1;
        int[] a = new int[] {intervals[0][0], intervals[0][1]};
        while (i < intervals.length) {
            int[] b = intervals[i];
            if (a[1] >= b[0]) {
                // 有交集
                if (a[1] <= b[1]) {
                    a[1] = b[1];
                }
                i++;
            } else {
                // 没有交集
                result.add(a);
                a = new int[] {b[0], b[1]};
                i++;
            }
        }

        result.add(a);

        return result.toArray(new int[result.size()][]);
    }


    public void test001() {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        int[][] result = merge(intervals);

        // [[1,6],[8,10],[15,18]]
        System.out.println("result:");
        System.out.println("answer:" + "[[1,6],[8,10],[15,18]]");
    }

    public void test002() {
        int[][] intervals = new int[][]{{1,4},{0,1}};

        int[][] result = merge(intervals);

        // [[1,6],[8,10],[15,18]]
        System.out.println("result:");
        System.out.println("answer:" + "[[0,4]]");
    }
}
