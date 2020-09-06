package com.剑指offer.t27二叉树的镜像;


import com.TreeNode;
/*
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

       4
      / \
    2   7
   / \ / \
  1  3 6  9
镜像输出：
       4
     /  \
    7   2
   / \ / \
  9  6 3  1

 */

public class Solution {

    // 遍历每一个节点  先序遍历
    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        helper(root);

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }


    // 对当前节点下的两个子节点进行交换
    public void helper(TreeNode root) {

        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.left = new TreeNode(9);

        Solution s = new Solution();
        s.mirrorTree(root).show();
    }
}
