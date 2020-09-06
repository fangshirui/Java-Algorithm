package com;

import java.io.EOFException;
import java.io.IOError;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) {
        this.val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }


    /*
    接收一个Integer[]数组来创建二叉树
    该数组满足层遍历，不存在的节点输入null
           1
         3   5
            7  8

     对应为   1 3 5 null null 7  8
     */
    public static TreeNode getTree(Integer[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean isLeft = true;  // 真 说明取左节点  假 取右节点下

        for (int i = 1; i < array.length; i++) {

            if (isLeft) {

                TreeNode node = queue.peek();

                if (node == null) {
                    throw new IllegalArgumentException("输入参数不合法");
                }
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.add(node.left);
                }
            } else {

                // 轮到右节点时，就可以删除队列上的首节点了
                TreeNode node = queue.poll();

                if (node == null) {
                    throw new IllegalArgumentException("输入参数不合法");
                }
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.add(node.right);
                }
            }

            isLeft = !isLeft;
        }


        return root;

    }

    public void show() {

        // 从上到下逐层打印
        // 广度优先搜索  使用队列
        System.out.println(val);
        Queue<TreeNode> queue = new LinkedList<>();

        int thisLevelNodes = 0;
        if (left != null) {
            queue.add(left);
            thisLevelNodes++;
        }
        if (right != null) {
            queue.add(right);
            thisLevelNodes++;
        }

        int nextLevelNodes = 0;


        System.out.println("-------------");
        while (!queue.isEmpty()) {


            TreeNode node = queue.poll();

            if (thisLevelNodes == 0) {
                thisLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                System.out.println("\n-------------");
            }

            System.out.print(node.val + "   ");
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
    }
}
