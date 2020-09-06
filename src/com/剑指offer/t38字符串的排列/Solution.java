package com.剑指offer.t38字符串的排列;

/*
输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

限制：
1 <= s 的长度 <= 8
s中所有字符不相同
 */

public class Solution {

    String[] res;
    char[] ch;

    public String[] permutation(String s) {

        ch = s.toCharArray();
        if (s.length() == 0 || s.length() > 8) {
            throw new IllegalArgumentException("参数不合法");
        }


        int len = 1;

        for (int i = 2; i <= s.length(); i++) {
            len *= i;
        }

        res = new String[len];

        for (int i = 0; i < len; i++) {


        }


        return res;
    }


    private void dfs(int x) {

    }

}
