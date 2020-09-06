package com.剑指offer.t34二叉树中和为某一值的路径;

import com.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
输入一棵二叉树和一个整数，
打印出二叉树中节点值的和为输入整数的所有路径。
从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

注意： 路径必须是根节点到叶子节点！！！！！！

给定如下二叉树，以及目标和sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1


[
   [5,4,11,2],
   [5,8,4,5]
]

节点总数 <= 10000
 */

public class Solution {

    // 最终答案
    LinkedList<List<Integer>> res = new LinkedList<>();

    // 答案中的一个解
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int tar) {
        if (root == null) return;

        path.add(root.val);
        tar -= root.val;


        if (tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList<>(path));


        recur(root.left, tar);
        recur(root.right, tar);

        // 向上退的时候 ，path 也向上退
        path.removeLast();
    }


    public static void main(String[] args) {

        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};


        TreeNode root = TreeNode.getTree(arr);

        Solution s = new Solution();
        System.out.println(s.pathSum(root, 22));
    }


}
