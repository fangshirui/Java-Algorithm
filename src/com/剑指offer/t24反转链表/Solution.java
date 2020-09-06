package com.剑指offer.t24反转链表;

import com.ListNode;

/*
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

0 <= 节点个数 <= 5000
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // 排除空指针或者 只有一个节点的情况
        if (head == null || head.next == null) {
            return head;
        }
        // 至少有两个节点
        ListNode p = head.next;
        // 先处理第一个节点，将其变为尾节点
        head.next = null;

        ListNode preNode = head;

        while (p != null) {
            ListNode nextNode = p.next;

            p.next = preNode;

            // p节点 和 preNode都前进一位。
            preNode = p;
            p = nextNode;

        }
        return preNode;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(3);

        Solution s = new Solution();
        s.reverseList(root).show();
    }
}
