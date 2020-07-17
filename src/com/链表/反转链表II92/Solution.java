package com.链表.反转链表II92;
/*
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL

 */

import com.ListNode;

import java.util.List;

public class Solution {

    // 默认链表长度大于1
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || m > n) {
            return null;
        }
        if (m == n) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy;
        ListNode next_node = null;

        ListNode m_pre_node = null;
        ListNode m_node = null;

        for (int i = 0; i <= n; i++) {
            if (i < m - 1) {
                node = node.next;
                continue;
            }

            // 第m -1 个节点
            if (i == m - 1) {
                m_pre_node = node;
                node = node.next;
                m_node = node;

                // 为 m -n 之间的节点 做铺垫
                next_node = m_node.next;
                continue;
            }


            // 第 m 个节点到 第n - 1个节点
            if (i < n) {
                ListNode temp = next_node.next;
                next_node.next = node;

                // 向后进一位
                node = next_node;
                next_node = temp;
                continue;

            }


            m_pre_node.next = node;

            m_node.next = next_node;

            break;


        }


        return dummy.next;
    }

}


class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode res = s.reverseBetween(head, 2, 4);


        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}



