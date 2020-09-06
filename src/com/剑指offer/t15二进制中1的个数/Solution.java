package com.剑指offer.t15二进制中1的个数;

/*
请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，
把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。

 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {


        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            // 使用无符号右移，因为 n 可能是负数；
            // 1000 0000 0000 0000 0000 0000 0000 0000  是最小的负数
            n = n >>> 1;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.hammingWeight(10));
        System.out.println(Integer.bitCount(-1));  // bitCount 可直接得答案。

    }
}
