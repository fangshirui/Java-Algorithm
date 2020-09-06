package com.剑指offer.t26树的子结构;

import com.TreeNode;
import sun.reflect.generics.tree.Tree;


/*
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

     3
    / \
   4   5
  / \
 1   2

 给定树 B:
  4
 /
1

返回true
 */


public class Solution {

    // 遍历A树
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }

        return isSubHelper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    // 判断 B 是否是 A 的 1. 根节点相同的
    //                 2. 子结构
    // 最开始传入的 A 和 B 都不可能为空
    public boolean isSubHelper(TreeNode A, TreeNode B) {
        //  如果B为空，说明B已经被遍历完了.
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;  // A 空 但是B 不为空 则 说明 不匹配。
        }
        if (A.val != B.val) {
            return false;
        }

        return isSubHelper(A.left, B.left) && isSubHelper(A.right, B.right);
    }


    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);

        System.out.println(s.isSubStructure(root, root2));
    }


}
