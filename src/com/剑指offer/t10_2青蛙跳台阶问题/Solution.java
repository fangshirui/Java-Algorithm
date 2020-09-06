package com.剑指offer.t10_2青蛙跳台阶问题;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），
如计算初始结果为：1000000008，请返回 1。

输入：n = 2
输出：2

输入：n = 7
输出：21

输入：n = 0
输出：1

提示：
0 <= n <= 100

 */
public class Solution {
    public int numWays(int n) {
        int prePre = 1;
        int pre = 0;

        int res = 0;
        for (int i = -1; i < n; i++) {
            res = (prePre + pre) % 1000000007;
            prePre = pre;
            pre = res;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numWays(7));
    }
}
