package com.剑指offer.t36二叉搜索树和双向链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
要求不能创建任何新的节点，只能调整树中节点指针的指向。
我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}


public class Solution {

    List<Node> list;

    /*
    此解法 为暴力解法，使用list储存所有节点位置，然后再修改。
    逻辑清楚，但是比较耗时，运算太多。
     */
    public Node treeToDoublyList(Node root) {


        if (root == null) {
            return null;
        }

        list = new ArrayList<>();

        dfs(root);

        int len = list.size();

        if (len == 1) {
            root.right = root;
            root.left = root;
            return root;
        }

        for (int i = 1; i < len - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i).left = list.get(i - 1);
        }

        list.get(0).left = list.get(len - 1);
        list.get(0).right = list.get(1);
        list.get(len - 1).left = list.get(len - 2);
        list.get(len - 1).right = list.get(0);

        return list.get(0);

    }

    private void dfs(Node root) {

        if (root == null) {
            return;
        }

        dfs(root.left);

        list.add(root);

        dfs(root.right);

    }


}
