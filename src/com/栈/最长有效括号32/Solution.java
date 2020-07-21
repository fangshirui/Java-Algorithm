package com.栈.最长有效括号32;

import java.util.Stack;

/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

输入： "(())()"
输出: 6
解释: 最长有效括号子串为 "(())()"


 */
public class Solution {
    public int longestValidParentheses(String s) {


        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int length = 0;
        int max_length = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    length = i - stack.peek();
                    max_length = Math.max(length, max_length);
                }
            }
        }

        return max_length;

    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String str = "())((())";
        System.out.println(s.longestValidParentheses(str));
    }
}
