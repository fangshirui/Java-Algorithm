package com.剑指offer.t35复杂链表的复制;
/*
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
每个节点除了有一个 next 指针指向下一个节点，
还有一个 random 指针指向链表中的任意节点或者 null。


-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。

 */

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }
        // key  原本节点   value 复制后对应的节点
        Map<Node, Node> map = new HashMap<>();
        Node node = head;

        while (node != null) {

            Node copyNode = new Node(node.val);
            map.put(node, copyNode);
            node = node.next;
        }

        node = head;
        while (node != null) {

            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }


        return map.get(head);
    }
}
