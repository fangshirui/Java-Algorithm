package com.二叉树.二叉树的最大深度104;

/*
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点


    3
   / \
  9  20
    /  \
   15   7

返回最大深度为3
 */

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
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



