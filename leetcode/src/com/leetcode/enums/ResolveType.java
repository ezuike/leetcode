package com.leetcode.enums;

import java.util.HashMap;
import java.util.Map;

public enum ResolveType {

    RESOLVED("resolved", "已解决"),

    RESOLVED_BY_ANSWER("resolved_by_answer", "参考答案解决"),

    UNRESOLVED("unresolved", "未解决");

    private final String code;
    private final String desc;
    private static final Map<String, String> map = new HashMap<>();

    ResolveType(String code, String desc) {
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
        for (ResolveType resolveType : values()) {
            map.put(resolveType.getCode(), resolveType.getDesc());
        }
    }
}
