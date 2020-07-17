package com.链表.重排链表143;

import com.ListNode;

import java.util.ArrayList;
import java.util.List;

/*

给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。


给定链表 1->2->3->4, 重新排列为 1->4->2->3.

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        List<ListNode>  list_node = new ArrayList<>();
        ListNode node = head;
        while (node != null){
            list_node.add(node);
            node = node.next;
        }

        int left = 0;
        int right = list_node.size() - 1;

        // 保证右节点和左节点至少间隔一个节点
        while (right - left > 1){
            ListNode left_node = list_node.get(left);
            ListNode right_node = list_node.get(right);

            left_node.next = right_node;
            right_node.next = list_node.get(left + 1);

            left++;
            right--;
        }

        // 他们相邻
        if(left + 1 == right){
            list_node.get(left).next = list_node.get(right);
            list_node.get(right).next = null;
        }else {

            // left == right
            list_node.get(left).next = null;
        }


    }
}


class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a = new ListNode(4);
        a.next = new ListNode(9);
        a.next.next = new ListNode( 3);
//        a.next.next.next = new ListNode(1);

        s.reorderList(a);
        while (a != null){
            System.out.print(a.val + "->");
            a = a.next;
        }
    }
}
