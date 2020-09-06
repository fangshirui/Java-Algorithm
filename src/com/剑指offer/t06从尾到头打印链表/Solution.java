package com.剑指offer.t06从尾到头打印链表;
/*
输入：head = [1,3,2]
输出：[2,3,1]
 */


import com.ListNode;

import java.util.*;

public class Solution {

    public int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();


        while (head != null) {

            list.add(head.val);

            head = head.next;
        }

        Collections.reverse(list);

        int[] res = new int[list.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode a = new ListNode(3);
        a.next = new ListNode(5);
        a.next.next = new ListNode(8);

        System.out.println(Arrays.toString(s.reversePrint(a)));
    }
}
