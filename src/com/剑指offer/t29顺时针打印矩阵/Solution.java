package com.剑指offer.t29顺时针打印矩阵;
/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100


matrix =   [[1,2,3,4],
            [5,6,7,8]
          ,[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */


import java.util.Arrays;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int row = matrix.length;
        int col = matrix[0].length;


        int[] res = new int[row * col];
        int index = 0;
        // 边界
        int left = 0, right = col - 1, top = 0, bottom = row - 1;


        // 每个循环打印一次边界。更新一次边界
        while (left <= right && top <= bottom) {


            for (int i = left; i <= right; i++) {
                res[index] = matrix[top][i];
                index++;
            }

            for (int j = top + 1; j <= bottom; j++) {
                res[index] = matrix[j][right];
                index++;
            }


            // 有的情况下，不能走如下的循环。比如不规则长方形矩阵
            if (left < right && top < bottom) {

                for (int i = right - 1; i > left; i--) {
                    res[index] = matrix[bottom][i];
                    index++;
                }

                for (int i = bottom; i > top; i--) {
                    res[index] = matrix[i][left];
                    index++;
                }
            }


            left++;
            right--;
            top++;
            bottom--;

        }


        return res;
    }


    public static void main(String[] args) {
        int[][] test = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        Solution s = new Solution();
        int[] ints = s.spiralOrder(test);

        System.out.println(Arrays.toString(ints));
    }
}
