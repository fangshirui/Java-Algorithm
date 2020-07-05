package com.通配符匹配44;

/*
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。

两个字符串完全匹配才算匹配成功。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。


输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

s = "aa"
p = "*"
输出: true
解释: '*' 可以匹配任意字符串。

输入:
s = "cb"
p = "?a"
输出: false
解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'


输入:
s = "adceb"
p = "*a*b"
输出: true
解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".

输入:
s = "acdcb"
p = "a*c?b"
输出: false
 */
public class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        /*
        动态规划
        dp[i][j] 表示字符串s前i个字符和模式p前j个字符是否能匹配。
        在状态转移时，
        模式p的第j个字符(p_j)对应的是字符串s的第i个字符(s_i)。

        p_j 有三种情况

        当 p_j 是 小写字母:
            dp[i][j] = (p_j == s_i) && dp[i - 1][j - 1]
        当 p_j 是 ? :
            dp[i][j] = dp[i - 1][j - 1]
        当 p_j 是 * ：
            此时可以p_j可以匹配零个或多个小写字母，因此状态转移方程分为两种情况，使用或者不使用*号

            不使用时:
                dp[i][j] = dp[i][j - 1]
            使用时:
                dp[i][j] = dp[i - 1][j]

            dp[i][j] = dp[i][j - 1] || dp[i - 1][j]


        整理上面的状态转移方程

        dp[i][j]  =   dp[i - 1][j - 1]                   s_i == p_j  或  p_j == '?'
                  =   dp[i][j - 1] || dp[i - 1][j]       p_j == '*'
                  =   false                              其他

         */

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;



        // 状态边界
//        for (int i = 1; i < m + 1; i++) {
//            dp[i][0] = false;
//        }

        for (int j = 1; j < n + 1; j++) {
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j - 1];
            }else {
                break;
            }
        }

        // 开始进行状态转移
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j -1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j -1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];

    }
}


class Main{
    public static void main(String[] args) {
        Solution ss = new Solution();

        String s = "";
        String p = "*?";

        System.out.println(ss.isMatch(s,p));
    }
}
