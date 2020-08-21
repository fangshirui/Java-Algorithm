package com.剑指offer.t03数组中重复数字;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findRepeatNumber(int[] nums) {

        Set<Integer> setNums = new HashSet<>();

        for (int num : nums) {

            if (setNums.contains(num)) {
                return num;
            } else {
                setNums.add(num);
            }
        }
        return -1;
    }


//    public int findRepeatNumber2(int[] nums){
//        // 原地置换法
//        for (int i = 0; i < nums.length ; i++) {
//
//            if (nums[nums[i]] == nums[i]){
//                return nums[i];
//            }else if( nums[nums[i]] == i){
//            }else {
//                // 交换
//                int temp = nums[i];
//                nums[i] = nums[temp];
//                nums[temp] = temp;
//            }
//        }
//        return -1;
//    }


    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {1, 0, 2, 2};
        System.out.println(s.findRepeatNumber(nums));
    }
}
