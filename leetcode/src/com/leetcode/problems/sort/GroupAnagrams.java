package com.leetcode.problems.sort;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String , List<String>> stringMap = new HashMap<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);

            String key = new String(temp);
            List<String> list = stringMap.get(key);
            if (null == list) {
                list = new LinkedList<>();
                stringMap.put(key, list);
            }
            list.add(str);
        }

       return new ArrayList<>(stringMap.values());
    }

    public void test001() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(strs);
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(result);
    }
}
