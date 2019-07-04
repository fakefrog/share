package com.twodfire.algorithm;

/**
 * @author baiyundou
 * @date 11:33 2019/7/4
 * @description LCS问题
 */
public class LongestCommonSubQueue {

    public static void main(String[] args) {
        String s1 = "BDCABA";
        String s2 = "ABCBDAB";
        int result = solution(s1, s2);
        System.out.println(result);
    }

    public static int solution(String s1, String s2) {
        //result数组表示以i长度(s1)和j长度(s2)的字符串的LCS大小
        int[][] result = new int[s1.length() + 1][s2.length() + 1];
        int[][] dir = new int[s1.length() + 1][s2.length() + 1];
        //分为2位  01表示j倒退一位,11表示i j 倒退一位,10表示i倒退一位
        for (int i = 0; i <= s1.length(); i++) {
            result[i][0] = 0;
        }
        for (int j = 0; j <= s2.length(); j++) {
            result[0][j] = 0;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                    dir[i][j] = 0b11;
                } else if (result[i][j - 1] > result[i - 1][j]) {
                    dir[i][j] = 0b01;
                    result[i][j] = result[i][j - 1];
                } else {
                    dir[i][j] = 0b10;
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        traverse(s1, s2, dir);
        return result[s1.length()][s2.length()];
    }

    private static void traverse(String s1, String s2, int[][] dir) {
    }

}

