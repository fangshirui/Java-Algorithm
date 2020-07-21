package com.二叉树.路径总和112;
/*
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。


给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 */


import com.TreeNode;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {

        // 若传入的是空节点。
        if(root == null ){
            return false;
        }

        // 若传入的是叶子节点。
        if(root.left == null && root.right == null){
            return sum == root.val;
        }


        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }


}


class Test{
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        TreeNode sss = null;

        System.out.println(s.hasPathSum(root, 2));

    }
}

