package com.剑指offer.t08用两个栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {

    // java中不鼓励使用原生 Stack<> 比较慢。
    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;  // 临时取用，储存时为空

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // 极端情况处理
        if (stack2.isEmpty()) {
            return -1;
        }

        int res = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return res;
    }


    public static void main(String[] args) {
        CQueue cQueue = new CQueue();

        cQueue.appendTail(1);
        cQueue.appendTail(3);
        cQueue.appendTail(3);
        cQueue.appendTail(4);

        System.out.println(cQueue.deleteHead());
    }
}
