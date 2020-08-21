package com.二进制.位1的个数191;

public class Solution {
    public int hammingWeight2(int n) {
        String hex = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < hex.length(); i++) {
            if (hex.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        // int 是4个字节，共32位
        for (int i = 0; i < 32; i++) {
            // 与掩码进行计算，如果不是全为0
            if ((n & mask) != 0) {
                res++;
            }

            mask = mask << 1;
        }
        return res;
    }

}


class Test {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.hammingWeight(3));
    }
}
