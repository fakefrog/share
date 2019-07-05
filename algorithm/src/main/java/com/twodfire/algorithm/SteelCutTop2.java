package com.twodfire.algorithm;


/**
 * @author baiyundou
 * @date 13:50 2019/7/5
 * @description 自顶向下带备忘录(len < = price.length)
 */
public class SteelCutTop2 {

    static Integer[] resultSet;

    public static void main(String[] args) {
        long l = System.nanoTime();
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int result = getMaxValueInit(price, 10);
        long l1 = System.nanoTime();
        System.out.println(result);
        System.out.println("cost:" + (l1 - l));
    }

    private static int getMaxValueInit(int[] price, int len) {
        resultSet = new Integer[len + 1];
        resultSet[0] = 0;
        return getMaxValue(price, len);
    }

    private static int getMaxValue(int[] price, int len) {
        if (resultSet[len] != null) {
            return resultSet[len];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            max = Math.max(max, price[i - 1] + getMaxValue(price, len - i));
        }
        resultSet[len] = max;
        return max;
    }

}
