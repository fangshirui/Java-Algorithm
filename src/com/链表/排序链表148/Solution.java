package com.链表.排序链表148;

import com.ListNode;

/*
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5


 */
public class Solution {

    // 采用归并排序
    public ListNode sortList(ListNode head) {

        // 首先排除空指针
        if(head == null){
            return null;
        }

        return helperSort(head);

    }

    private ListNode helperSort(ListNode head){

        // 递归基！！！
        // 若head 为单个节点时则返回自身。
        if(head.next == null){
            return head;
        }

        // 找中点
        ListNode middle = findMiddle(head);
        ListNode tail = middle.next;

        // 分隔成两个链表
        middle.next = null;


        // 分而治之！！！
        ListNode left = helperSort(head);
        ListNode right = helperSort(tail);

        // 合并子问题 将两个升序链表合并成一个升序链表
        ListNode res = mergeTwoLists(left, right);

        return res;
    }


    private ListNode findMiddle( ListNode head){
        // 采用快慢指针
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2){


        ListNode dummy = new ListNode(-1);

        ListNode node = dummy;

        while (l1 != null && l2 != null){

            if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }

            node = node.next;
        }

        // 若l1剩余
//        if(l1 != null){
//            node.next = l1;
//            return dummy.next;
//        }
//
//        // 若l2剩余
//        if(l2 != null){
//            node.next = l2;
//            return dummy.next;
//        }

        // 若 l1 和l2 同时为空, 则 只会在初始输入两者均为空时发生。
        // 所以直接返回为空


        if(l1 != null){
            node.next = l1;
        }else{
            node.next = l2;
        }

        return dummy.next;
    }


}


class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a = new ListNode(4);
        a.next = new ListNode(9);
        a.next.next = new ListNode( 3);
        a.next.next.next = new ListNode(1);


        ListNode b = s.sortList(a);
        while (b != null){
            System.out.print(b.val + "->");
            b = b.next;
        }
    }
}

