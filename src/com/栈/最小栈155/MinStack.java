package com.栈.最小栈155;

import java.util.Stack;

/*
设计一个支持push pop top 操作，并可以在常数时间内检索到最小元素的栈。

提示：
pop、top 和 getMin 操作总是在 非空栈 上调用。
 */


// 方法1 自建数据结构，使用链表。
public class MinStack {
    /** initialize your data structure here. */

    StackNode dummy;
    StackNode top_node;

    public MinStack() {

        dummy = new StackNode(-1);
        top_node = dummy;

    }

    public void push(int x) {

        StackNode new_node = new StackNode(x);
        new_node.min_val = Math.min(top_node.min_val , x);

        new_node.next = top_node;

        top_node = new_node;
    }

    public void pop() {
        top_node = top_node.next;
    }

    public int top() {
        return top_node.val;
    }

    public int getMin() {
        return top_node.min_val;
    }
}


class StackNode{
    int val;
    int min_val;
    StackNode next;

    public StackNode(int val){
        this.val = val;
        min_val = Integer.MAX_VALUE;
        next = null;
    }
}


// 方法2 使用通用栈，稍加改造。
//public class MinStack{
//    Stack<Integer> val_stack;
//    Stack<Integer> min_val_stack;
//
//    public MinStack() {
//        val_stack = new Stack<>();
//        min_val_stack = new Stack<>();
//        min_val_stack.push(Integer.MAX_VALUE);
//    }
//
//    public void push(int x) {
//        val_stack.push(x);
//
//        min_val_stack.push(Math.min(min_val_stack.peek(),x));
//
//    }
//
//    public void pop() {
//        val_stack.pop();
//        min_val_stack.pop();
//    }
//
//    public int top() {
//        return val_stack.peek();
//    }
//
//    public int getMin() {
//
//        return min_val_stack.peek();
//    }
//}

