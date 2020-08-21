package com.剑指offer.t04二维数组的查找;

/*
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 */


public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int n = matrix.length; // 行
        int m = matrix[0].length; // 列

        // 从右上角看，该数组是一个平衡二叉树。
        // 使用二叉树搜索的思想
        // 坐标 i j
        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }

        return false;

    }


    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] mat = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};


        System.out.println(s.findNumberIn2DArray(mat, 19));
    }
}
