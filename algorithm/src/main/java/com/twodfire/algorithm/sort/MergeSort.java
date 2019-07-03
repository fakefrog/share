package com.twodfire.algorithm.sort;

import java.util.Arrays;

/**
 * @author baiyundou
 * @date 18:32 2019/7/3
 * @description
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 5, 9, 6, 7, 2, 10, 6, 12, 1};
        mergerSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergerSort(int[] nums, int start, int end) {
    }

}
