package com.twodfire.algorithm;

/**
 * @author baiyundou
 * @date 11:05 2019/7/4
 * @description 活动选择
 */
public class ActivityChoose {

    public static void main(String[] args) {
        int[] si = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] fi = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        String[] ac = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        String result = activityChoose(si, fi, ac);
        System.out.println(result);
    }

    public static String activityChoose(int s[], int f[], String ac[]) {
        int m = s.length;
        StringBuilder sb = new StringBuilder(ac[0]);
        int i = 0;
        for (int j = 1; j < m; j++) {
            if (s[j] >= f[i]) {
                sb.append(ac[j]);
                i = j;
            }
        }
        return sb.toString();
    }
}
