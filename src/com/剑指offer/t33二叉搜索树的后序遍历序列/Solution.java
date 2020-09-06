package com.剑指offer.t33二叉搜索树的后序遍历序列;

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
否则返回 false。假设输入的数组的任意两个数字都互不相同。

 参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3

输入: [1,6,3,2,5]
输出: false

输入: [1,3,2,6,5]
输出: true

数组长度 <= 1000
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {

        if (postorder == null || postorder.length == 0) {
            return false;
        }

        return verifyPostorderHelper(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorderHelper(int[] postorder, int start, int end) {


        if (start >= end) {
            return true;
        }

        int p = start;
        while (postorder[p] < postorder[end]) {
            p++;
        }

        // 此时p指向第一个右子树的节点
        int rightIndex = p;

        while (postorder[p] > postorder[end]) {
            p++;
        }
        // 此时的p 若没有指向 end 则说明  没有满足要求

        return p == end && verifyPostorderHelper(postorder, start, rightIndex - 1)
                && verifyPostorderHelper(postorder, rightIndex, end - 1);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1, 6, 3, 2, 5};
        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println(s.verifyPostorder(test));
        System.out.println(s.verifyPostorder(test2));
    }

}
