package com.数组.两数之和1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 两数之和
    public  int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> nums_map = new HashMap<>();
        int[] res = new int[]{0, 1};

        for (int i = 0; i < nums.length; i++) {
            nums_map.put(nums[i], i);
        }

        System.out.println(nums_map.toString());

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (nums_map.containsKey(complement) && nums_map.get(complement) != i) {

                res[0] = i;
                res[1] = nums_map.get(complement);
                return res;

            }

        }

        return res;
    }
}
