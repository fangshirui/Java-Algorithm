package com.剑指offer.t14_1剪绳子;
/*
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */


public class Solution {
    /*
    使用贪婪算法，只要尽可能地剪长度为3的绳子乘积就比较大
     */
    public int cuttingRope(int n) {

        // 其他不合法输入
        if (n < 2) {
            return 0;
        }


        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }


        int res = 1;
        while (n > 4) {
            n = n - 3;
            res *= 3;
        }
        res *= n;

        return res;
    }


    /*
    使用动态规划
     */
    public int cuttingRope2(int n) {

        // 待补充
        return 0;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.cuttingRope(4));

    }

}
