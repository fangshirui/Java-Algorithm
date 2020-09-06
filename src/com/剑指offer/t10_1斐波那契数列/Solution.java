package com.剑指offer.t10_1斐波那契数列;

/*
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

F(0) = 0, F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

提示：
0 <= n <= 100
由于答案过大，会导致超出int范围，因此本题特别规定，对于超出1000000007的值需要取模运算。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */


public class Solution {


    public int fib(int n) {

        int prePre = -1;
        int pre = 1;
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
        System.out.println(s.fib(5));
    }
}
