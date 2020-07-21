package com.DP.零一矩阵542;
/*
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。


输入:

0 0 0
0 1 0
0 0 0
输出:

0 0 0
0 1 0
0 0 0

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1

说明：
给定矩阵的元素个数不超过 10000。
给定矩阵中至少有一个元素是 0。
矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */

// 使用动态规划
// 写出转移方程


/*
f(i,j) =   1 + min(f(i - 1, j) , f(i, j - 1) , f(i + 1, j),  f(i, j + 1) )  , if matrix[i][j] == 1
       =   0                                                                , if matrix[i][j] == 0
 */
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        // 将对应的dp数组所有对应的0全部赋0,全部对应的1给最大值。
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;  // 因为最大只有10000个元素
            }
        }

        // 距离最短的0在当前位置的左上方某位置。
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // 至少第二行起步,才可以进行 行比较。
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }

                // 至少第二列起步，才可以进行 列比较

                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }

            }
        }

        // 距离最短的0在当前位置的右下方某位置。
        // 由于已经遍历过一遍。现在反方向再遍历一遍就可以保证每个距离都正确

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {

                // 至少倒数第二行才可以进行 行比较
                if (i < row - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }

                // 至少倒数第二列才可以进行 列比较
                if (j < col - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }

        return dp;
    }
}

