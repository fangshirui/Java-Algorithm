package com.数组中第K个最大元素215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
在未排序的数组中找到第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

说明:
你可以假设 k 总是有效的。即满足 1 <= k <= 数组长度。
 */



public class Solution {
    // 该解法不是最好的。最好的应该使用堆排序，堆排序不浪费性能，只排序前k个！！。
    public int findKthLargest(int[] nums, int k) {

        Integer[] nums_Int = new Integer[nums.length];

        for (int i = 0; i < nums.length ; i++) {
            nums_Int[i] = nums[i];
        }

        List<Integer> nums_list = new ArrayList<>();
        Collections.addAll(nums_list, nums_Int);

        Collections.sort(nums_list);
        Collections.reverse(nums_list);

        return nums_list.get(k - 1);
    }
}


class Main{
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {212,32,42,14,44};
        System.out.println(s.findKthLargest(nums, 1));
    }
}