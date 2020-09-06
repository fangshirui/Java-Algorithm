package com.剑指offer.t17打印从1到最大的n位数;

import java.util.Arrays;

/*
  解法1 对应 leetcode
  解法2 对应 书上的大数问题
 */
public class Solution {

    /*
    不考虑大数问题的解法
     */
    public int[] printNumbers(int n) {

//        char[] max_char = new char[n];
//        Arrays.fill(max_char , '9');
//        String str = new String(max_char);
//        int max = Integer.parseInt(str);

        int max = (int) Math.pow(10, n) - 1;

        int[] res = new int[max];

        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    /*
    书中原题 打印 n位数
     */

    BigNumber bigNumber;

    static class BigNumber {
        char[] valueChar;
        int n;

        // 此数组储存值，但是它的顺序是反的
        //  00001  代表 10000
        public BigNumber(int n) {
            this.n = n;
            valueChar = new char[n];
            Arrays.fill(valueChar, '0');
        }

        // 如果返回假 说面加1失败 到顶了
        public boolean plus() {
            int index = 0;
            while (valueChar[index] == '9') {

                if (index >= n - 1) {
                    return false;
                }

                valueChar[index] = '0';
                index++;
            }
            // 现在  valueChar[index] 不等于'9';
//            valueChar[index] = (char) (Integer.parseInt(String.valueOf(valueChar[index])) + 1 + '0');
            valueChar[index] += 1;  // 由于字符可以运算  '1' + 1 = '2'
            return true;
        }

        public String toString() {
            StringBuilder res = new StringBuilder();
            int index = n - 1;
            boolean isZero = true;
            while (index >= 0) {

                // 去除前面的0
                if (valueChar[index] == '0' && isZero) {
                    index--;
                    continue;
                }
                res.append(valueChar[index]);
                isZero = false;
                index--;
            }

            return res.toString();
        }

    }


    public void printNumbers2(int n) {
        bigNumber = new BigNumber(n);
        while (bigNumber.plus()) {
            System.out.println(bigNumber.toString());
        }

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.printNumbers2(3);
    }
}
