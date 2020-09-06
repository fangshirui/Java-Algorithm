package com;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        this.val = x;
    }

    public void show() {

        System.out.print(val);
        ListNode node = next;
        while (node != null) {

            System.out.print("->" + node.val);
            node = node.next;
        }

    }
}
