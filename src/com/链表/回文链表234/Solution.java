package com.链表.回文链表234;

import com.ListNode;

import java.util.*;

/*
请判断一个链表是否为回文链表。
输入: 1->2
输出: false

输入: 1->2->2->1
输出: true
 */
public class Solution {
    public boolean isPalindrome(ListNode head){
        // 空链表 和单个
        if(head == null || head.next == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();

        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while (right > left){


            if(list.get(left).equals(list.get(right))){
                right--;
                left++;
            }else {
                return false;
            }

        }
        return true;
    }
}


