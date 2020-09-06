package com.剑指offer.t31栈的压入弹出序列;

import java.util.Deque;
import java.util.LinkedList;

/*
输入两个整数序列，第一个序列表示栈的压入顺序，
请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed是popped的排列。

 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int pushedIndex = 0;
        int poppedIndex = 0;

        Deque<Integer> stack1 = new LinkedList<>();


        while (poppedIndex < popped.length) {

            // 如果压入栈空
            if (stack1.isEmpty()) {
                if (pushedIndex < pushed.length) {
                    stack1.push(pushed[pushedIndex]);
                    pushedIndex++;
                }
            }

            // 当前弹出栈的第一个元素与压入栈顶相等
            if (popped[poppedIndex] == stack1.peek()) {
                stack1.pop();
                poppedIndex++;
                continue;
            }

            // 当前stack顶 不和 弹出序列第一个相等 ,且 压入栈还没有全部压入
            if (pushedIndex < pushed.length) {
                stack1.push(pushed[pushedIndex]);
                pushedIndex++;
                continue;
            }

            // 当前stack顶 不和 弹出序列第一个相等， 且压入栈已经全部压入
            if (pushedIndex == pushed.length) {
                return false;
            }


        }

        return true;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 3, 5, 1, 2};

        System.out.println(s.validateStackSequences(pushed, poped));
    }
}
