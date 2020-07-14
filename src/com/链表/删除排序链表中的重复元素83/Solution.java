package com.链表.删除排序链表中的重复元素83;
/*
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

输入: 1->1->2
输出: 1->2

输入: 1->1->2->3->3
输出: 1->2->3
 */

import com.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode node = head;
//        Set<Integer> set = new HashSet<>();

//        set.add(head.val);

        while (node.next != null){
//            if(set.contains(node.next.val)){
//                // 跳过重复
//                node.next = node.next.next;
//            }else {
//                set.add(node.next.val);
//                node = node.next;
//            }

            if(node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }

        return head;

    }
}


class Test{
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(2);
    }
}

