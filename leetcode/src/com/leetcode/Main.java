package com.leetcode;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[\\w.]{1,3}");
        String a = ("330101" + "0000000000000000").substring(0, 12);

        System.out.println(pattern.matcher("2323232323").matches());

    }
}
