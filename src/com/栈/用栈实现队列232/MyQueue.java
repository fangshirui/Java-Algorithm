package com.栈.用栈实现队列232;

import java.util.Stack;

/*
push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。


MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false


你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

 */
public class MyQueue {

    Stack<Integer> stack;  // 顺序
    Stack<Integer> stack_reverse; //逆序
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        stack_reverse = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {


        // 将逆序转为顺序
        while (!stack_reverse.isEmpty()){
            stack.push(stack_reverse.pop());
        }

        // 在顺序后添加新元素
        stack.push(x);

        // 将顺序再次转换为逆序
        while (!stack.isEmpty()){
            stack_reverse.push(stack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack_reverse.pop();

    }

    /** Get the front element. */
    public int peek() {
        return stack_reverse.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack_reverse.isEmpty();
    }
}
