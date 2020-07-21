package com.DFS.岛屿数量200;

/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

输入:
[
['1','1','1','1','0'],
['1','1','0','1','0'],
['1','1','0','0','0'],
['0','0','0','0','0']
]
输出: 1


输入:
[
['1','1','0','0','0'],
['1','1','0','0','0'],
['0','0','1','0','0'],
['0','0','0','1','1']
]
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成
 */
public class Solution {

    private int column;
    private int row;

    // 使用深度优先搜索

    // 注意 char[a][b] 中 a是行，b是列。
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0){
            return 0;
        }

        row = grid.length;

        column = grid[0].length;


        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;

    }

    private void dfs(char[][] grid, int row, int column) {

        // 如果是'0' 及时返回，如果是'1',将其标记为'0'，表示已经访问。
        if (grid[row][column] == '0') {
            return;
        } else {
            grid[row][column] = '0';
        }

        // 防止越界
        if (column + 1 < this.column ) {
            dfs(grid, row, column + 1);
        }

        if (row + 1 < this.row ) {
            dfs(grid, row + 1, column);
        }

        if(column - 1 >= 0){
            dfs(grid, row, column - 1);
        }

        if(row - 1 >= 0){
            dfs(grid,row - 1, column);
        }
    }


}


class Test {
    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] grid = {{'1','0'},{'1','0'}};

//        System.out.println(grid);
        System.out.println(s.numIslands(grid));


    }
}