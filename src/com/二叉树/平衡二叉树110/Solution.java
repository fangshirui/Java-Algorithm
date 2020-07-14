package com.二叉树.平衡二叉树110;
import com.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

    3
   / \
  9  20
    /  \
   15   7

  返回 true


       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

 返回 false

 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int left_depth = getDepth(root.left);
        int right_depth = getDepth(root.right);

        if(Math.abs(left_depth - right_depth) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }



    private int getDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int depth = 0;
        int nodes_in_level = 0;

        while (!queue.isEmpty()) {
            nodes_in_level = queue.size();

            for (int i = 0; i < nodes_in_level; i++) {

                TreeNode temp = queue.poll();

                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            depth++;
        }

        return depth;
    }

}


class Test{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        Solution s = new Solution();

        System.out.println(s.isBalanced(root));
    }
}
