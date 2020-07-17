package com.二叉树.二叉搜索树中的插入操作701;

import com.TreeNode;

import javax.swing.event.TreeExpansionEvent;

/*
给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。

 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果

给定二叉搜索树:

        4
       / \
      2   7
     / \
    1   3

和 插入的值: 5

输出：

         4
       /   \
      2     7
     / \   /
    1   3 5

 也可以输出：
         5
       /   \
      2     7
     / \
    1   3
         \
          4

 */
public class Solution {


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode node = root;

        while (true) {
            if(val > node.val){
                if(node.right == null){
                    node.right = new TreeNode(val);
                    break;
                }else {
                    node = node.right;
                }
            }else {

                if(node.left == null){
                    node.left = new TreeNode(val);
                    break;
                }else {
                    node = node.left;
                }
            }
        }

        return root;
    }
}
