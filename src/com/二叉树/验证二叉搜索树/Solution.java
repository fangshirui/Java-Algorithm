package com.二叉树.验证二叉搜索树;

import com.TreeNode;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。


输入:
    2
   / \
  1   3
输出: true


输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
 */
public class Solution {
    private long temp = Long.MIN_VALUE;
    private boolean res = true;

    private void dfs(TreeNode root){

        if(root == null) return;

        dfs(root.left);

        if(temp < root.val){
            temp = root.val;
        }else {
            res = false;
            return;
        }

        dfs(root.right);

    }


    public boolean isValidBST(TreeNode root) {

        dfs(root);

        return res;
    }
}


class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        /*
                  11
                 / \
                10  13
               /    / \
              3   12   18
         */

        TreeNode root = new TreeNode(11);
        TreeNode p = new TreeNode(12);
        TreeNode q = new TreeNode(18);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(13);
        root.right.left = p;
        root.right.right = q;


        TreeNode root2 = new TreeNode(Integer.MIN_VALUE);

        System.out.println(s.isValidBST(root2));
    }
}


