package com.链表.复制带随机指针的链表138;
/*
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的 深拷贝。

提示：
-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node{
    int val;
    Node next;

    // 多一个随机指针， 可以是空，也可以指向该链表中的任意节点。
    Node random;

    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }

}

public class Solution {

    // key: 旧节点   value: 新节点
    Map<Node, Node> visited = new HashMap<>();

    // 获得旧节点的克隆
    // 旧节点可能已被克隆，此时不可重复克隆
    public Node getClonedNode(Node node){
        if(node == null){
            return null;
        }

        if (!visited.containsKey(node)) {
            visited.put(node, new Node(node.val));
        }
        return visited.get(node);

    }

    public Node copyRandomList(Node head){
        if(head == null){
            return null;
        }

        Node oldNode = head;
        // 新建一个链表的头结点
        Node newNode = new Node(head.val);

        visited.put(oldNode, newNode);


        while (oldNode != null){
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return visited.get(head);

    }

}
