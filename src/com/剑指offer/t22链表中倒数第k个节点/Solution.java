package com.剑指offer.t22链表中倒数第k个节点;

import com.ListNode;

/*
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
 */
public class Solution {

    // 使用遍历一遍的算法
    public ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null || k == 0) {
            return null;
        }

        int len = 0;
        ListNode dummy = head;
        ListNode node = null;

        while (head != null) {
            len++;
            if (len == k) {
                node = dummy;
            }
            if (len > k) {
                node = node.next;
            }

            head = head.next;
        }


        return node;
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(3);

        Solution s = new Solution();
//        s.getKthFromEnd(root,0).show();
    }
}
