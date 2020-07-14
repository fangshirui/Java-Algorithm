package com.二叉树.二叉树的层序遍历102;

import com.TreeNode;

import java.util.*;

/*
输入：
    3
   / \
  9  20
    /  \
   15   7

输出：
[
  [3],
  [9,20],
  [15,7]
]

 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int nodes_in_level = 0;
        while (!queue.isEmpty()){
            nodes_in_level = queue.size();

            List<Integer> level_nodes_list = new ArrayList<>();
            for (int i = 0; i < nodes_in_level ; i++) {
                TreeNode temp = queue.poll();

                if(temp.left != null){
                    queue.add(temp.left);
                }

                if(temp.right != null){
                    queue.add(temp.right);
                }

                level_nodes_list.add(temp.val);
            }
            res.add(level_nodes_list);
        }

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

        List<List<Integer>> a = s.levelOrder(root2);

        System.out.println(a.toString());
    }
}
