package com.剑指offer.t07重建二叉树;


import com.TreeNode;

import java.util.*;

/*
输入某二叉树的前序遍历和中序遍历的结果，
请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

 */


public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;

        // 储存 中序遍历 各个元素的位置的map  key  元素值 ; value  index
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, length - 1,
                0, length - 1, inorderMap);
    }

    public TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd,
                                    int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {

        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);

        if (preorderStart == preorderEnd) {
            return root;
        }

        int rootIndexOfInorder = indexMap.get(rootVal);

        // 左子树个数
        int leftNodes = rootIndexOfInorder - inorderStart;

        TreeNode leftSubTree = buildTreeHelper(preorder, preorderStart + 1, preorderStart + leftNodes,
                inorderStart, rootIndexOfInorder - 1, indexMap);

        TreeNode rightSubTree = buildTreeHelper(preorder, preorderStart + leftNodes + 1, preorderEnd,
                rootIndexOfInorder + 1, inorderEnd, indexMap);

        root.left = leftSubTree;
        root.right = rightSubTree;

        return root;

    }


    public static void main(String[] args) {
        Solution s = new Solution();

        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        /*
                3
             9     20
                 15   7
         */

        TreeNode treeNode = s.buildTree(preOrder, inOrder);

        // 宽度优先打印

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.println(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
    }

}
