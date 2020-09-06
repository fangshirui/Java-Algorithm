package com.剑指offer.t32_3从上到下打印二叉树III;

import com.TreeNode;

import java.util.*;

/*
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

例如:
给定二叉树:[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]

 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // 广度优先搜索  使用队列
        List<Integer> levelNodeList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int thisLevelNodes = 1;
        int nextLevelNodes = 0;

        queue.add(root);

        boolean isOnOrder = true;  // 第一层为顺序

        while (!queue.isEmpty()) {


            TreeNode node = queue.poll();

            if (thisLevelNodes == 0) {
                thisLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;

                if (!isOnOrder) {
                    Collections.reverse(levelNodeList);
                }
                isOnOrder = !isOnOrder;
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


        if (!isOnOrder) {
            Collections.reverse(levelNodeList);
        }
        res.add(levelNodeList);

        return res;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(9);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution s = new Solution();
        System.out.println(s.levelOrder(root));
    }


}
