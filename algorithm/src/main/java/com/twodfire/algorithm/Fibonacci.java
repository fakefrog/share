package com.twodfire.algorithm;

/**
 * @author baiyundou
 * @date 14:24 2019/7/5
 * @description
 */
public class Fibonacci {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        long result = recursion(45);
//        int result = iter(45);
        System.out.println(result);
        long l1 = System.currentTimeMillis();
        System.out.println("cost:" + (l1 - l));

/*        Long[] resultSet = new Long[65536];
        resultSet[0] = 1L;
        resultSet[1] = 1L;
        resultSet[2] = 2L;
        long l = recursionWithRemember(65536, resultSet);
        System.out.println(l);*/
    }

    private static long iter(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        long[] result = new long[n];
        result[1] = 1;
        result[0] = 1;
        for (int i = 3; i <= n; i++) {
            result[i - 1] = result[i - 2] + result[i - 3];
        }
        return result[n - 1];
    }

    private static long recursion(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        return recursion(i - 1) + recursion(i - 2);
    }

    private static long recursionWithRemember(int i, Long[] resultSet) {
        if (resultSet[i - 1] != null) {
            return resultSet[i - 1];
        }
        resultSet[i - 1] = recursionWithRemember(i - 1, resultSet) + recursionWithRemember(i - 2, resultSet);
        return resultSet[i - 1];
    }


}
