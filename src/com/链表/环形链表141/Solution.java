package com.链表.环形链表141;

import com.ListNode;
import com.sun.media.sound.SoftMixingSourceDataLine;

import java.util.List;

/*
给定一个链表，判断链表中是否有环。


输入：head = 3->2->0->4->2,
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。 


输入：head = 1 -> 2 -> 1
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }
        // 使用快慢指针，若快指针追上了慢指针，则表示有环

        ListNode slow = head;
        ListNode fast = head.next;

        while ( fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }

        return false;

    }



}

class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a = new ListNode(4);
        a.next = new ListNode(9);
        a.next.next = new ListNode( 3);
        a.next.next.next = a;

        System.out.println(s.hasCycle(a));

    }

}