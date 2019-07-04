package com.twodfire.algorithm;

import java.util.Scanner;

/**
 * @author baiyundou
 * @date 11:05 2019/7/4
 * @description 从网上copy的活动选择算法实现
 */
public class ActivityChoose {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("按照结束时间的先后输入11个活动的活动名称(一个占一行)：");
        String[] ac = new String[11];
        for (int i = 0; i < ac.length; i++) {
            ac[i] = sc.nextLine();
        }
        int[] s = new int[11];
        int[] f = new int[11];
        System.out.println("依次输入各活动的开始时间：");
        for (int i = 0; i < s.length; i++) {
            s[i] = sc.nextInt();
        }
        System.out.println("依次输入各活动的结束时间：");
        for (int j = 0; j < f.length; j++) {
            f[j] = sc.nextInt();
        }
        String str = greed_Activity_Selector(s, f, ac);
        System.out.println("一个最大相互兼容集合为：" + str);

    }

    public static String greed_Activity_Selector(int s[], int f[], String ac[]) {
        int m = s.length;
        String str = ac[0];
        int i = 0;
        for (int j = 1; j < m; j++) {
            if (s[j] >= f[i]) {
                str += " " + ac[j];
                i = j;
            }
        }
        return str;
    }
}
