package com.leetcode.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度标准
 * 简单：一看题目就有思路，能正常解出来
 * 中等：有一点思路，稍微参考解题答案，能很快反应过来。
 * 困难：完全没有思路，参考官方答案后，也不是很理解。
 */
public enum Difficulty {
    EASY("easy", "简单"),

    MEDIUM("Medium", "中等"),

    HARD("hard", "困难");

    private final String code;
    private final String desc;
    private static final Map<String, String> map = new HashMap<>();

    Difficulty(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDesc(Integer code) {
        return map.get(code);
    }

    static {
        for (Difficulty difficulty : values()) {
            map.put(difficulty.getCode(), difficulty.getDesc());
        }
    }
}
