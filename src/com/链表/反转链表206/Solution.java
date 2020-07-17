package com.链表.反转链表206;

import com.ListNode;

/*
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL


 */


public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next_node = head.next;
        ListNode current_node = head;

        head.next = null;

        while (next_node != null) {
            ListNode temp = next_node.next;
            next_node.next = current_node;
            current_node = next_node;
            next_node = temp;
        }

        return current_node;

    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode res = s.reverseList(head);


        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}