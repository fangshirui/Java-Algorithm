package com.二叉树的最大路径和124;


/*
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42
 */

import sun.reflect.generics.tree.Tree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){

        dfs(root);

        return maxSum;
    }


    /*
    返回root为根节点的子树中，该root节点所能向上提供的最大值。
     */
    public int dfs(TreeNode root){

        if (root == null) return 0;

        // 单独根节点提供最大值（左右节点均为负数）
        int mid = root.val;

        // 左节点和根节点的和
        int left = root.val + dfs(root.left);

        // 右节点和根节点的和
        int right = root.val + dfs(root.right);


        // 左 + 中 + 右
        int lmr = left + right -root.val;

        // maxSum 要比较5个
        maxSum = Math.max(maxSum, Math.max( mid, Math.max(left, Math.max(right, lmr))));


        // dfs返回值，要比较三个就行了。
        return Math.max(mid, Math.max(left, right));
    }


}


class Main{
    public static void main(String[] args) {

        TreeNode a = new TreeNode(-10);
        a.left = new TreeNode(-5);
        a.right = new TreeNode(-8);
        a.left.left = new TreeNode(100);
        a.left.right = new TreeNode(8);

        Solution s = new Solution();

        System.out.println(s.maxPathSum(a));

    }
}
