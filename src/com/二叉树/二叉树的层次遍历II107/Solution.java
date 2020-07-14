package com.二叉树.二叉树的层次遍历II107;

import com.TreeNode;

import java.util.*;


/*
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
输入：
    3
   / \
  9  20
    /  \
   15   7

输出：
 [
  [15,7],
  [9,20],
  [3]
]
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int nodes_in_level = 0;
        while (!queue.isEmpty()){
            nodes_in_level = queue.size();
            TreeNode temp;
            List<Integer> nodes_value_list = new ArrayList<>();

            for (int i = 0; i < nodes_in_level; i++) {
                temp = queue.poll();


                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }

                nodes_value_list.add(temp.val);

            }

            res.add(nodes_value_list);
        }

        Collections.reverse(res);

        return res;
    }
}

class Test{
    public static void main(String[] args) {
        Solution s = new Solution();

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


        TreeNode root2 = null;

        List<List<Integer>> a = s.levelOrderBottom(root2);

        System.out.println(a.toString());
    }
}
