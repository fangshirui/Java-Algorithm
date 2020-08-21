package com.字符串.验证回文串125;

/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

输入: "A man, a plan, a canal: Panama"
输出: true


输入: "race a car"
输出: false

 */

public class Solution {
    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // 如果不是字母或数字则左指针加1
            while (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;

                // 防止出现全为非字母和数字，
                if(left > s.length() -1){
                    return false;
                }
            }
            // 如果右侧不是字母或数字则右指针减1
            while (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // 此时左右指针位置必为数子或字符
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;

        }

        return true;
    }
}
