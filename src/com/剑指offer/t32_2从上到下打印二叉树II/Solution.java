package com.剑指offer.t32_2从上到下打印二叉树II;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

[
  [3],
  [9,20],
  [15,7]
]
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }

        // 广度优先搜索  使用队列
        List<Integer> levelNodeList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int thisLevelNodes = 1;
        int nextLevelNodes = 0;

        queue.add(root);

        while (!queue.isEmpty()) {


            TreeNode node = queue.poll();

            if (thisLevelNodes == 0) {
                thisLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                res.add(levelNodeList);
                levelNodeList = new ArrayList<>();

            }
            // 将当前层节点加入到该层
            levelNodeList.add(node.val);
            thisLevelNodes--;


            if (node.left != null) {
                queue.add(node.left);
                nextLevelNodes++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelNodes++;
            }

        }

        res.add(levelNodeList);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution s = new Solution();
        System.out.println(s.levelOrder(root));
    }
}
