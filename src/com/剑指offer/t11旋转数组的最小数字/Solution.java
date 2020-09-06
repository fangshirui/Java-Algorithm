package com.剑指offer.t11旋转数组的最小数字;

import javax.swing.plaf.SliderUI;

/*

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，
数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。




 */
public class Solution {

    // 普通的查找法 ，不是特别好
    public int minArray(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int len = numbers.length;

        if (numbers[0] < numbers[len - 1]) {
            return numbers[0];
        }

        int pre = numbers[0];

        for (int i = 1; i < len; i++) {
            if (numbers[i] < pre) {
                return numbers[i];
            }

            pre = numbers[i];
        }

        return numbers[0];
    }


    // 采用二分查找法
    // 由于比较过多，只有在数组长度极大的时候才会有优势
    public int minArray2(int[] numbers) {

        // 特别情况
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int len = numbers.length;

        int left = 0;
        int right = len - 1;


        while (left < right) {
            int mid = (left + right) / 2;
            // 如果中间数小于 后面的数，则说明，最小数在前面
            // 举例   5 1 2 3 4
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {   //  3 4 5 1 2 最小数在后面,而且排除中间数是最小数的可能
                left = mid + 1;
            } else {
                // 此处是 中间数和 最后数一样大的情况
                // 3 4 5 5 5
                // 或者
                // 5 3 3

                right--;
            }
        }
        return numbers[left];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {3, 4, 5, 6, 1, 3, 3};
        System.out.println(s.minArray2(a));
    }

}
