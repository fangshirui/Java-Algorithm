package com.二进制.二进制求和67;

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。
1 <= a.length, b.length <= 10^4

输入: a = "11", b = "1"
输出: "100"

输入: a = "1010", b = "1011"
输出: "10101"

输入: a = "0", b = "0"
输出: "0"

 */



public class Solution {
    public String addBinary(String a, String b){
        // 由于a和b可能很长，数字很大，所以不能直接用数学加。

        // 如果a长，则调换
        if (a.length() > b.length()){
            String temp = b;
            b = a;
            a = temp;
        }


        // 将 a 和 b 都反转
        StringBuilder tempA = new StringBuilder(a);
        StringBuilder tempB = new StringBuilder(b);

        a = tempA.reverse().toString();
        b = tempB.reverse().toString();

//        System.out.println(a);


        StringBuilder res = new StringBuilder();

        int carry = 0;

        for (int i = 0; i < b.length() ; i++) {

            // 如果超出长度其值就为0
            int a_value = i < a.length() ? charToInt(a.charAt(i)) : 0;
            int sum = ( a_value + charToInt(b.charAt(i)) + carry);
            int benwei = sum % 2;
            carry =  sum / 2;

            res.append(benwei);
        }

        if(carry > 0){
            res.append("1");
        }



        return res.reverse().toString();

    }




    private int charToInt(char ch){
        if (ch == '0'){
            return 0;
        }else {
            return 1;
        }
    }
}







class Main{
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "10011";
        String b = "100";



        System.out.println(s.addBinary(a, b));
        System.out.println(a);

    }
}



