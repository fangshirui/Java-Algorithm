package com.二叉树.二叉树的中序遍历94;
/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]

 */


import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root){
        helper(root);
        return res;
    }

    private void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
}




class Test{
    public static void main(String[] args) {
        Solution s= new Solution();
                /*
                  3
                 / \
                10  13
                   / \
                  5   9
         */

        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(9);
        root.left = new TreeNode(10);
        root.right = new TreeNode(13);
        root.right.left = p;
        root.right.right = q;


        List<Integer> res = s.inorderTraversal(root);

        System.out.println(res);

    }
}