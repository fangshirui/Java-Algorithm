package com.栈.逆波兰表达式求值150;
/*
根据逆波兰表示法，求表达式的值


说明：
整数除法仅保留整数部分。
给定的逆波兰表达式总是有效的，也即不存在除以0的情况。

输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

输入: ["4", "13", "5", "/", "+"]
输出: 6
解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 */

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();

        int len = tokens.length;

        for (int i = 0; i < len  ; i++) {
            if(isDigital(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }else {
                // 必是四种运算符之一
                int b = stack.pop();
                int a = stack.pop();
                Integer c = 0;

                switch (tokens[i]){
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                }

                stack.push(c);

            }
        }


        return stack.peek();
    }


    private boolean isDigital(String str){

        // 对于基本类型 != 是比较值，对于引用类型，!= 是比较地址。
        // 对于所有引用类型，若希望比较其值而不是本身，都应用 equals()
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
            return false;
        }
        return true;
    }
}



class Test{
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] str = {"34","17","/","3","+"};

        System.out.println(s.evalRPN(str));
    }
}
