package com.链表.合并两个升序链表21;

import com.ListNode;

import java.util.List;

/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){


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

        // l1剩余
        if(l1 != null){
            node.next = l1;
            return dummy.next;
        }

        // l2剩余
        if(l2 != null){
            node.next = l2;
            return dummy.next;
        }

        // l1 和l2 同时为空
        node.next = null;


        return dummy.next;
    }

}


class Test{
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode( 3);


        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(5);

        ListNode res = s.mergeTwoLists(a,b);

        while (res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
