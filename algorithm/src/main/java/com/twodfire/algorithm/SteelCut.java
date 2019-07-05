package com.twodfire.algorithm;


/**
 * @author baiyundou
 * @date 13:39 2019/7/5
 * @description 自底而上(len任意)
 */
public class SteelCut {

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int result = getMaxValue(price, 10);
        System.out.println(result);
    }

    private static int getMaxValue(int[] price, int len) {
        int[] result = new int[len + 1];
        result[0] = 0;
        if (len < price.length) {
            for (int i = 1; i <= len; i++) {
                result[i] = price[i - 1];
            }
        } else {
            for (int i = 1; i <= price.length; i++) {
                result[i] = price[i - 1];
            }
        }
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j <= i / 2; j++) {
                result[i] = Math.max(result[i], result[i - j] + result[j]);
            }
        }
        return result[len];
    }

}
