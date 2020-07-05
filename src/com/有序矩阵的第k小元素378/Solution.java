package com.有序矩阵的第k小元素378;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。


你可以假设 k 的值永远是有效的，1 ≤ k ≤ n^2

 */
public class Solution {

    // 暴力解法
    public int kthSmallestBrute(int[][] matrix, int k) {

        List<Integer> temp = new ArrayList<>();

        int n = matrix.length;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                temp.add(matrix[i][j]);
            }
        }

        Collections.sort(temp);

        return temp.get(k - 1);
    }

    // 采用二分查找
    public int kthSmallest(int[][] matrix, int k){


        return 0;
    }

}


class Main{
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] matrix = {{1,3,5}, {4,6,8}, {7, 10, 12}};

        System.out.println(s.kthSmallest(matrix, 4));

    }
}
