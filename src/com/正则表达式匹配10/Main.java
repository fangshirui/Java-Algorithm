package com.正则表达式匹配10;

public class Main {
    public static void main(String[] args) {
        String s = "sdfed3";
        String p = ".*";

        Solution solution = new Solution();

        System.out.println(solution.isMatch(s,p));
    }
}
