package com.twodfire.algorithm.sort;

import java.util.Arrays;

/**
 * @author baiyundou
 * @date 18:32 2019/7/3
 * @description 快排
 */
public class FastSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        fastSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void fastSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int posValue = nums[start];
        int l = start;
        int r = end;
        while (l < r) {
            while (l < r && nums[r] >= posValue) {
                r--;
            }
            while (l < r && nums[l] <= posValue) {
                l++;
            }
            if (l != r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        int temp = nums[start];
        nums[start] = nums[l];
        nums[l] = temp;
        fastSort(nums, start, l - 1);
        fastSort(nums, l + 1, end);
    }

}
