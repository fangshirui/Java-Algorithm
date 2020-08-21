package com.二进制.只出现一次的数字136;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

输入: [2,2,1]
输出: 1

输入: [4,1,2,1,2]
输出: 4
 */
public class Solution {
    public int singleNumber(int[] nums) {

        int single = 0;
        for (int num : nums) {
            single ^= num;  // 做异或运算， a^a = 0  0 ^ b = b , 且满足交换律
        }
        return single;
    }
}


class Test {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {3, 23, 3, 4, 5, 5, 4};

        System.out.println(s.singleNumber(nums));


    }
}
