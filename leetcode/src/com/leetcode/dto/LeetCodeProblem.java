package com.leetcode.dto;

import java.io.Serializable;

public class LeetCodeProblem implements Serializable {
    private static final long serialVersionUID = 1675635354975565223L;

    /**
     * 序号
     */
    private Long number;

    /**
     * 标题
     */
    private String title;

    /**
     * 题目链接
     */
    private String link;

    /**
     * 题目描述
     */
    private String description;

    /**
     * 题目难度
     */
    private String difficulty;

    /**
     * 解决类型
     */
    private String status;

    /**
     * 解题思路
     */
    private String solvingIdeas;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSolvingIdeas() {
        return solvingIdeas;
    }

    public void setSolvingIdeas(String solvingIdeas) {
        this.solvingIdeas = solvingIdeas;
    }
}
