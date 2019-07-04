package com.twodfire.algorithm.sort;

import java.util.Arrays;

/**
 * @author baiyundou
 * @date 18:32 2019/7/3
 * @description 归并排
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 5, 9, 6, 7, 2, 10, 6, 12, 1};
        mergerSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergerSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergerSort(nums, start, middle);
        mergerSort(nums, middle + 1, end);
        //start -> middle   middle+1->end
        merge(nums, start, middle, end);
    }

    private static void merge(int[] nums, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int left = start;
        int right = middle + 1;
        while (left <= middle && right <= end) {
            temp[index++] = nums[left] < nums[right] ? nums[left++] : nums[right++];
        }
        while (left <= middle) {
            temp[index++] = nums[left++];
        }
        while (right <= end) {
            temp[index++] = nums[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
    }

}
