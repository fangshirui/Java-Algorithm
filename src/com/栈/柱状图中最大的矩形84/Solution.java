package com.栈.柱状图中最大的矩形84;
/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

输入: [2,1,5,6,2,3]
输出: 10
 */

public class Solution {
    // 题目还可以使用单调栈法，下面的是暴力解法。
    public int largestRectangleArea(int[] heights) {

        if(heights == null){
            return 0;
        }
        int res = 0;
        int current_height;
        int len = heights.length;

        for (int i = 0; i < len ; i++) {
            current_height = heights[i];

            int index_to_left = i;
            int index_to_right = i;

            while (index_to_left >= 0 && current_height <= heights[index_to_left]){
                index_to_left--;
            }

            while (index_to_right < len && current_height <= heights[index_to_right]){
                index_to_right++;
            }

            // 此时 左侧指针多走了一位，右侧指针也多走了一位。 总宽度是 右指针减去左指针再减1
            int current_Area = (index_to_right - index_to_left - 1) * current_height;
            res = Math.max(res, current_Area);
        }


        return res;
    }
}

class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] heights = {2,1,5,6,2,3};

        System.out.println(s.largestRectangleArea(heights));
    }
}