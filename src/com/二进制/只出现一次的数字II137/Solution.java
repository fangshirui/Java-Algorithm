package com.二进制.只出现一次的数字II137;

import java.util.HashSet;
import java.util.Set;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？


输入: [2,2,3,2]
输出: 3
 */
public class Solution {

    // 使用set ，O(n)储存空间
    // 如需O(1)的空间，则需要用到二进制法，这里略过。
    public int singleNumber(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        long numArraySum = 0;
        for (int num : nums) {
            numSet.add(num);
            numArraySum += num;
        }

        long numSetSum = 0;
        for (int num : numSet) {
            numSetSum += num;
        }

        return (int) ((3 * numSetSum - numArraySum) / 2);

    }
}
