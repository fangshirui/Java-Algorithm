package com.最长重复子数组718;
/*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

输入:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出: 3
解释:
长度最长的公共子数组是 [3, 2, 1]。

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 */


public class Solution {
    /*
    以下为暴力解法，超出时间限制了
     */
    public int findLengthBrute(int[] A, int[] B) {

        int long_sub_len = 0;

        int len_a = A.length;
        int len_b = B.length;

        for (int i = 0; i < len_a ; i++) {
            for (int j = 0; j < len_b ; j++) {
                if(A[i] == B[j]){
                    int ii = i;
                    int jj = j;
                    int sub_len = 0;

                    while (A[ii] == B[jj]){
                        sub_len++;
                        ii++;
                        jj++;

                        if(ii >= len_a || jj >= len_b){
                            break;
                        }
                    }

                    if (sub_len > long_sub_len){
                        long_sub_len = sub_len;
                    }
                }
            }
        }

        return long_sub_len;
    }

    // 动态规划 -> 制表策略
    public int findLength(int[] A, int[] B){

        int n = A.length;
        int m = B.length;

        int res = 0;

        int[][] dp = new int[n + 1][m + 1]; // 默认值为0


        for (int i = n - 1; i >= 0 ; i--) {
            for(int j = m - 1; j >= 0; j--){

                if(A[i] == B[j]){
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }else {
                    dp[i][j] = 0;
                }

                res = Math.max(dp[i][j] , res);

            }
        }

        return res;
    }

}


class Main{
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a = {34,23,54,2,13,54,32,11,54,21,2};
        int[] b = {22,32,54,21,43,22,43,2,13,54,32,11};

        System.out.println(s.findLength(a,b));

    }
}