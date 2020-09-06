package com.剑指offer.t12矩阵中的路径;

import com.sun.org.glassfish.external.amx.AMXGlassfish;

/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，
那么该路径不能再次进入该格子。
例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径.

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

输入：board = [["A","B","C","E"],
             ["S","F","C","S"],
             ["A","D","E","E"]]

     word = "ABCCED"
输出：true


1 <= board.length <= 200
1 <= board[i].length <= 200
 */
public class Solution {

    private int row;
    private int col;


    public boolean exist(char[][] board, String word) {

        char[] words = word.toCharArray();
        this.row = board.length;
        this.col = board[0].length;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                int index = 0;

                if (dfs(board, i, j, words, index)) {
                    return true;
                }

            }
        }

        return false;

    }

    boolean dfs(char[][] board, int i, int j, char[] word, int index) {

        // 处理位置越界的情况，均返回假
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return false;
        }

        // 判断当前位置是否满足要求。
        if (board[i][j] != word[index]) {
            return false;
        }

        // 如果word已经到尽头，说明全部匹配成功，返回真
        if (index == word.length - 1) {
            return true;
        }

        // 需要往下搜索，为了防止向后搜索，需要把已经搜索过的字符给修改为一个完全不同的字符。（回溯法）
        index += 1;
        char temp = board[i][j];
        board[i][j] = '.';

        //  回溯法(将已经搜索过的地方进行标记，并且如果此路不通，可以清除标记，复原原来的样子)  + dfs
        // 试探每一条路径是否成功，如果不成功就复原。
        boolean res = dfs(board, i + 1, j, word, index) || dfs(board, i - 1, j, word, index)
                || dfs(board, i, j - 1, word, index) || dfs(board, i, j + 1, word, index);

//        还原
        board[i][j] = temp;

        return res;

    }


    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] a = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String ss = "BFCE";
        String s2 = "CCEDB";

        System.out.println(s.exist(a, s2));
    }

}
