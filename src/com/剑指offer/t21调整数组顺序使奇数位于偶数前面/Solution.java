package com.剑指offer.t21调整数组顺序使奇数位于偶数前面;

/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。

1 <= nums.length <= 50000
1 <= nums[i] <= 10000
 */


import java.util.Arrays;

public class Solution {

    /*
    此方法满足leetcode 但是没有修改原来的数组，不合书上原意。
     */
    public int[] exchange2(int[] nums) {

        int[] res = new int[nums.length];

        int last = nums.length - 1;
        int first = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                res[first] = nums[i];
                first++;
            } else {
                res[last] = nums[i];
                last--;
            }
        }

        return res;
    }


    /*
    修改原数组的解法
     */
    public int[] exchange(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            // 寻找偶数
            if ((nums[left] & 1) != 0) {
                left++;
                continue;
            }

            // 寻找奇数
            if ((nums[right] & 1) != 1) {
                right--;
                continue;
            }

            // 现在奇数偶数都已经找到，调换位置即可。

            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;

            // 调换后，左指针指向的数必不是偶数，右指针指向的数必不是奇数。
            left++;
            right--;

        }
        return nums;


    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.exchange(new int[]{1, 3, 4, 2, 9, 4, 32,})));

    }
}
