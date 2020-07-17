package com.链表.分隔链表;

import com.ListNode;

/*
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {

        // 保存小于x的链表
        ListNode dummy = new ListNode( -1);
        ListNode node_less_than_x = dummy;


        // 保存大于x的链表
        ListNode dummy2 = new ListNode(-1);
        ListNode node_bigger_than_x = dummy2;

        dummy.next = head;
        ListNode node = head;





        while (node != null){
//            ListNode temp = node.next;

            if(node.val < x){
                node_less_than_x.next = node;
                node_less_than_x = node_less_than_x.next;
            }else{
                node_bigger_than_x.next = node;
                node_bigger_than_x = node_bigger_than_x.next;
            }

            node = node.next;
        }
        node_bigger_than_x.next = null;

        node_less_than_x.next = dummy2.next;



        return dummy.next;
    }
}




class Test{
    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode a = new ListNode(91);
        a.next = new ListNode(22);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(33);
        a.next.next.next.next = new ListNode(13);



        ListNode res = s.partition(a,30);

        while (res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }


    }
}

