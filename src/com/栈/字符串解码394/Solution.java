package com.栈.字符串解码394;
/*
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入

输入：s = "3[a]2[bc]"
输出："aaabcbc"


输入：s = "3[a2[c]]"
输出："accaccacc"


输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String decodeString(String s){

        StringBuffer res = new StringBuffer();

        Stack<Character> stack = new Stack<>();

        int len = s.length();

        for (int i = 0; i < len; i++) {

            char current_char = s.charAt(i);

            // 每次遇到']'时处理一次。
            if(current_char != ']'){
                // 不是']'就简单压入栈
                stack.push(current_char);

            }else {
                // 是[]中的字符串，需要重复的字符串
                // 取出[] 之中的字符串

                List<Character> repeat_chars = new ArrayList<>();

                char ch;

                while (stack.peek() != '['){
                    ch = stack.pop();
                    repeat_chars.add(ch);
                }

                // 弹出'['
                stack.pop();

                // 取出'['前的数字
                StringBuilder str_re_num = new StringBuilder();

                while ( !stack.isEmpty() &&  Character.isDigit(stack.peek()) ){
                    str_re_num.append(stack.pop());
                }

                str_re_num.reverse();

                int repeat = Integer.parseInt(str_re_num.toString());


                // 将[]重复字符串输入栈中。
                for(int j = 0 ; j < repeat; j++){

                    for (int k = repeat_chars.size() -1; k >= 0; k--) {
                        stack.push(repeat_chars.get(k));
                    }

//                    for(Character chr : repeat_chars){
//                        stack.push(chr);
//                    }
                }


            }

        }


        for(Character chr : stack){
            res.append(chr);
        }

        return res.toString();

    }






}







class Test {

    public static void main(String[] args) {
        Solution s = new Solution();

        String str = "3[a10[bc]]";

        System.out.println(s.decodeString(str));
    }
}