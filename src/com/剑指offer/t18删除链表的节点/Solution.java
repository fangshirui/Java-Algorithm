package com.剑指offer.t18删除链表的节点;
/*
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

题目保证链表中节点的值互不相同
若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */


import com.ListNode;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode node = head;
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                break;
            }

            node = node.next;
            pre = pre.next;
        }

        return dummy.next;
    }
}
