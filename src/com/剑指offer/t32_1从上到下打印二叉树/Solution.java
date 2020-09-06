package com.剑指offer.t32_1从上到下打印二叉树;

import com.TreeNode;

import java.util.*;

/*
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
给定二叉树:
    3
   / \
  9  20
    /  \
   15   7

 返回  [3,9,20,15,7]
 */
public class Solution {

    public int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> resList = new ArrayList<>(32);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resList.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] res = new int[resList.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }

        return res;

    }
}
