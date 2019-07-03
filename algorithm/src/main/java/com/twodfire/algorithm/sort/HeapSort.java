package com.twodfire.algorithm.sort;

import java.util.Arrays;

/**
 * @author baiyundou
 * @date 18:35 2019/7/3
 * @description
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {5, 8, 5, 7, 6, 7, 9, 1, 7, 3};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapify(array, 0, i);
        }
    }

    private static void buildHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }
    }

    private static void heapify(int[] array, int pos, int size) {
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        int maxIndex = pos;
        int maxValue = array[pos];
        if (left < size) {
            if (array[left] > maxValue) {
                maxIndex = left;
                maxValue = array[left];
            }
        }
        if (right < size) {
            if (array[right] > maxValue) {
                maxIndex = right;
                maxValue = array[right];
            }
        }
        if (maxIndex != pos) {
            int temp = array[pos];
            array[pos] = maxValue;
            array[maxIndex] = temp;
            heapify(array, maxIndex, size);
        }
    }

}
