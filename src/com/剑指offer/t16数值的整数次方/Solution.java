package com.剑指offer.t16数值的整数次方;

/*
实现函数double Power(double base, int exponent)，求base的exponent次方。
不得使用库函数，同时不需要考虑大数问题。

输入: 2.00000, 10
输出: 1024.00000

说明:
-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1]
 */
public class Solution {

    /*
    如下方法，在leetcode中超时了
     */
    public double myPow2(double x, int n) {
        // 注意点 可能为负数
        if (Math.abs(x - 0) < 0.0000000001) {
            return 0.0;
        }

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double res = 1;
        if (n > 0) {

            while (n > 0) {
                res *= x;
                n--;
            }

            return res;
        } else {
            while (n < 0) {
                res *= x;
                n++;
            }
            return 1 / res;
        }
    }

    // 这次采用 二分手段 当n 很大时候，将他分解
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        // 由于 -2^31 反转后 int 放不下。
        long ex = n;

        double res = 1.0;

        if (ex < 0) {
            x = 1 / x;
            ex = -ex;
        }

        // 反转后，ex 始终大于0
        while (ex > 0) {
            if ((ex & 1) == 1) {
                res *= x;
            }
            x *= x;
            ex = ex >> 1;
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(0.0, 0));
    }
}
