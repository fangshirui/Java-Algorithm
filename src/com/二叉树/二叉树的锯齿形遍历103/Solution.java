package com.二叉树.二叉树的锯齿形遍历103;

import com.TreeNode;

import java.util.*;

/*
给定一个二叉树，返回其节点值的锯齿形层次遍历。
（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

给定二叉树 [3,9,20,null,null,15,7],
输入：
    3
   / \
  9  20
    /  \
   15   7

输出：
[
  [3],
  [20,9],
  [15,7]
]
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();

        deque.offer(root);

        int nodes_in_level;

        boolean in_order = true;

        // 每次循环处理一层节点
        while (!deque.isEmpty()) {
            nodes_in_level = deque.size();

            List<Integer> level_nodes_list = new ArrayList<>();

            for (int i = 0; i < nodes_in_level; i++) {
                TreeNode temp = deque.pollFirst();

                if (temp.left != null) {
                    deque.add(temp.left);
                }

                if (temp.right != null) {
                    deque.add(temp.right);
                }

                level_nodes_list.add(temp.val);

            }

            if (!in_order) {
                Collections.reverse(level_nodes_list);
            }

            in_order = !in_order;

            res.add(level_nodes_list);
        }

        return res;
    }
}


class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        /*
                  3
                 / \
                10  13
               /    / \
              3    5   9
         */

        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(9);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(13);
        root.right.left = p;
        root.right.right = q;


        TreeNode root2 = null;

        List<List<Integer>> a = s.zigzagLevelOrder(root);

        System.out.println(a.toString());
    }
}

