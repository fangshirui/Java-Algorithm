package com.两数相加2;
/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。


输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */


import com.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode sum = res;
        int carray = 0;

        while (l1.next != null && l2.next != null){
            sum.val = (l1.val + l2.val + carray )%10;
            carray = (l1.val + l2.val + carray)/10;

            sum.next = new ListNode(0);
            l1 = l1.next;
            l2 = l2.next;
            sum = sum.next;
        }

        // l1 和l2 一样长时
        if (l1.next == null && l2.next == null){
            sum.val =(l1.val + l2.val + carray)%10 ;

            carray = (l1.val + l2.val + carray)/10;

            if (carray > 0){
                sum.next = new ListNode(1);
            }

            return  res;
        }

        // l1 和 l2 不一样长。
        if(l1.next == null){
            addB(l2, l1, sum, carray);
        }else {
            addB(l1, l2, sum, carray);
        }

        return res;
    }

    // longer 为大于一个节点的链表
    // shorter 只有一个节点。
    public void addB(ListNode longer, ListNode shorter, ListNode sum,int jinwei){
        sum.val = (longer.val + shorter.val + jinwei) % 10;
        jinwei = (longer.val + shorter.val + jinwei) / 10;

        sum.next = longer.next;

        if(jinwei == 0){
            return;
        }

        while (jinwei > 0){

            if(longer.next == null){
                longer.next = new ListNode(1);
                return;
            }

            longer = longer.next;
            int temp = (longer.val + jinwei);
            longer.val = temp %10;
            jinwei = temp / 10;

        }

    }

}



class Main{
    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(9);

        Solution s = new Solution();
        ListNode l3 = s.addTwoNumbers(l1,l2);

        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
            System.out.println("-----");
        }
    }
}
