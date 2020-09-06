package com.剑指offer.t13机器人运动范围;

/*
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？


 */
public class Solution {

    private int count;
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {

        visited = new boolean[m][n];

        count = 0;

        int i = 0;
        int j = 0;
        dfs(m, n, i, j, k);

        return count;
    }

    private void dfs(int row, int col, int i, int j, int k) {

        // 边界条件 或者已经被访问
        if (i >= row || j >= col || visited[i][j]) {
            return;
        }


        // 判断这个格子是否满足要求，（能否到达）
        if (canCatched(i, j, k)) {
            count++;
            visited[i][j] = true;

            dfs(row, col, i + 1, j, k);
            dfs(row, col, i, j + 1, k);
        }

    }

    private boolean canCatched(int i, int j, int k) {

        int sum = i / 10 + i % 10 + j / 10 + j % 10;

        if (sum <= k) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.movingCount(3, 3, 2));
    }
}
