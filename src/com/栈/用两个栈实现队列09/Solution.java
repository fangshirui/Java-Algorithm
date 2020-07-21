package com.栈.用两个栈实现队列09;

/*
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。
(若队列中没有元素，deleteHead 操作返回 -1 )

最多会对 appendTail、deleteHead 进行 10000 次调用

 */

public class Solution {
}


class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }
}


/*
下面的解法不是按照题意要求的解法。
若使用两个栈实现堆栈，
则基本原理是这样：
首先栈只能弹出队尾，
若想只用栈实现队列，则需要两个栈。
当需要弹出队首时，将A栈所有元素全部倒写到B栈中，最后一个即是要弹出的元素。
然后将B栈元素再倒回A栈。
这样A栈就弹出了队首了。
 */

class CQueue {

    private final Node dumb;

    private Node head_node;

    private Node tail_node;

    public CQueue() {

        dumb = new Node(-1);
        tail_node = dumb;
        head_node = dumb;

    }

    public void appendTail(int value) {

        Node new_node = new Node(value);

        tail_node.next = new_node;
        tail_node = new_node;

        if (head_node == dumb) {
            head_node = new_node;
        }

    }

    public int deleteHead() {

        if (head_node == dumb) {
            return -1;
        }

        if (head_node.next == null) {
            int res = head_node.value;
            head_node = dumb;
            tail_node = dumb;
            dumb.next = null;

            return res;
        }

        int res = head_node.value;
        head_node = head_node.next;
        dumb.next = head_node;
        return res;
    }

}


class Main {
    public static void main(String[] args) {
        CQueue cq = new CQueue();

        cq.appendTail(9);
        cq.appendTail(8);
        cq.appendTail(0);

        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());

        cq.appendTail(8);
        System.out.println(cq.deleteHead());
    }
}
