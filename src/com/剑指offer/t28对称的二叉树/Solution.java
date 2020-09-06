package com.剑指offer.t28对称的二叉树;

import com.TreeNode;
/*
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */

public class Solution {
    public boolean isSymmetric(TreeNode root) {


        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);


    }

    // 两子树是否是镜像
    private boolean helper(TreeNode A, TreeNode B) {

        if (A == null && B == null) {
            return true;
        }

        if (A == null || B == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return helper(A.left, B.right) && helper(A.right, B.left);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        Solution s = new Solution();
        System.out.println(s.isSymmetric(root));
    }
}
