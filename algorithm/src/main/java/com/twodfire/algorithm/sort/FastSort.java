package com.twodfire.algorithm.sort;

import java.util.Arrays;

/**
 * @author baiyundou
 * @date 18:32 2019/7/3
 * @description
 */
public class FastSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        fastSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void fastSort(int[] nums, int start, int end) {
    }

}
