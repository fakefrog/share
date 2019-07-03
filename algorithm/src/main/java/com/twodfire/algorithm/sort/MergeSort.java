package com.twodfire.algorithm.sort;

import java.util.Arrays;

/**
 * @author baiyundou
 * @date 18:32 2019/7/3
 * @description
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] ints = {3, 4, 1, 5, 9, 6, 7, 2, 10, 6, 12, 1};
        mergerSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    public static void mergerSort(int[] ins, int start, int end) {
    }

}
