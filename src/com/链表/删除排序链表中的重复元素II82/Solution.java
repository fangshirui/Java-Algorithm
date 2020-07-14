package com.链表.删除排序链表中的重复元素II82;

import com.ListNode;

import java.util.List;

/*
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:
输入: 1->2->3->3->4->4->5
输出: 1->2->5

示例 2:
输入: 1->1->1->2->3
输出: 2->3
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode node = head;

        // 哑节点在头节点前。
        ListNode dummy_node = new ListNode(-1);
        dummy_node.next = head;

        // 第一个pre_node 是哑节点。
        ListNode pre_node = dummy_node;

        int duplicate_value = head.val;


        while (node.next != null){

            // 跳过两个重复
            if(node.val == node.next.val){
                duplicate_value = node.val;

                pre_node.next = node.next.next;
                node = pre_node;

                // 跳过一个重复
            }else if (duplicate_value == node.next.val){
                node.next = node.next.next;
            }else  {
                pre_node = node;
                node = node.next;
            }
        }

        return dummy_node.next;
    }
}


class Test{
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(3);



        ListNode res = s.deleteDuplicates(a);

        while (res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }


    }
}
