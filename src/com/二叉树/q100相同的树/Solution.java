package com.二叉树.q100相同的树;

import com.TreeNode;

/*
给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Solution {
    public boolean isSameTree(TreeNode A, TreeNode B) {
        // 直到他们找到null 才停止递归
        if (A == null && B == null) {
            return true;
        }

        if (A == null || B == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return isSameTree(A.left, B.left) && isSameTree(A.right, B.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        Solution s = new Solution();
        System.out.println(s.isSameTree(root, root2));
    }
}
