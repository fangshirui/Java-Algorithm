package com.二叉树.有序数组转换为二叉搜索树108;

/*
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {


        return toNode(nums, 0, nums.length - 1);


    }

    private TreeNode toNode(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = toNode(nums, start, mid - 1);
        root.right = toNode(nums, mid + 1, end);

        return root;
    }
}


class Main{
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,10};

        Solution s = new Solution();
        TreeNode n = s.sortedArrayToBST(nums);

        System.out.println(n.val +  " " + n.left.val + " " + n.right.val);

    }
}
