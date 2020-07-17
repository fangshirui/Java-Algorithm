package com.链表.环形链表II142;

import com.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

说明：不允许修改给定的链表。

输入：head = 3 -> 2 -> 0 -> 4 -> 2
输出： 2    （这里的是指2所在的节点）


 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();

        while (head != null){

            if(set.contains(head)){
                return head;
            }

            set.add(head);
            head = head.next;
        }

        return null;
    }
}
