package com.剑指offer.t25合并两个增序的链表;

import com.ListNode;

import java.util.List;
/*
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {

                node.next = l1;
                // l1 和 node 均前进一位
                node = l1;
                l1 = l1.next;
            } else {
                node.next = l2;

                node = l2;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            node.next = l2;
        } else {
            node.next = l1;
        }

        return dummy.next;

    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);


        Solution s = new Solution();
        s.mergeTwoLists(l1, l2).show();
    }
}