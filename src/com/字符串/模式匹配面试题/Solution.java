package com.字符串.模式匹配面试题;

/*
你有两个字符串，即pattern和value。
pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），
该字符串也匹配像"a"、"ab"和"b"这样的模式。
但需注意"a"和"b"不能同时表示相同的字符串。
编写一个方法判断value字符串是否匹配pattern字符串。

输入： pattern = "abba", value = "dogcatcatdog"
输出： true


输入： pattern = "aaaa", value = "dogcatcatdog"
输出： false

输入： pattern = "abba", value = "dogdogdogdog"
输出： true

输入： pattern = "ab", value = ""
输出： false

输入： pattern = "", value = ""
输出： true

输入： pattern = "", value = "sa"
输出： false


提示：
0 <= len(pattern) <= 1000
0 <= len(value) <= 1000
你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。


 */




public class Solution {
    public boolean patternMatching(String pattern, String value) {
        int len = value.length();

        int a_number = getNumberOfAInPattern(pattern);

        int b_number = pattern.length() - a_number;

        if (len == 0 && pattern.length() == 0) {
            return true;
        }


        int a_char_len;
        int b_char_len;

        int a_char_len_max;

        // 防止除数为0
        a_char_len_max = (a_number == 0) ? 0 : len / a_number;

        for (a_char_len = 0; a_char_len <= a_char_len_max; a_char_len++) {

            boolean temp_res = true;

            // 防止除数为0
            b_char_len = (b_number == 0) ? 0 : (len - a_number * a_char_len) / b_number;

            // 长度匹配了
            if (a_char_len * a_number + b_char_len * b_number == len) {


                int i = 0;    // value中的下标

                String tempA = "$";
                String tempB = "$";

                boolean tempAIsAssigned = false;
                boolean tempBIsAssigned = false;


                for (char ch : pattern.toCharArray()) {
                    if (ch == 'a') {
                        String a = value.substring(i, i + a_char_len);
                        i = i + a_char_len;

                        if (!tempAIsAssigned) {
                            tempA = a;
                            tempAIsAssigned = true;
                        }

                        if (!tempA.equals(a)) {
                            temp_res = false;
                            break;
                        }


                    } else {
                        String b = value.substring(i, i + b_char_len);
                        i = i + b_char_len;

                        if (!tempBIsAssigned) {
                            tempB = b;
                            tempBIsAssigned = true;
                        }

                        if (!tempB.equals(b)) {
                            temp_res = false;
                            break;
                        }

                    }
                }

                // 如果a和b相同，将临时设为假
                if (tempA.equals(tempB)) {
                    System.out.println("以下为字符串ab相同的不符合条件的例子");
                    System.out.println("a:" + tempA);
                    System.out.println("b:" + tempB);
                    temp_res = false;
                }


                // 如果这一条件下的ab字符串符合条件。则直接返回真，否则暂时不返回。
                if (temp_res) {
                    System.out.println("a:" + tempA);
                    System.out.println("b:" + tempB);
                    return true;
                }

            }


        }

        return false;
    }

    private int getNumberOfAInPattern(String pattern) {
        int count = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == 'a') {
                count++;
            }
        }

        return count;
    }

}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String pattern = "";
        String value = "asasasasas";

        System.out.println(s.patternMatching(pattern, value));
    }
}