package com.xuegao.algorithm.sort;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] newArray = new int[array.length];
        mergeSort(array, 0, array.length - 1, newArray);
    }

    private void mergeSort(int[] array, int left, int right, int[] newArray) {
        // base case
        if (left >= right) {
            return;
        }

        // 「分」
        int mid = left + (right - left) / 2;

        // 「治」
        mergeSort(array, left, mid, newArray);
        mergeSort(array, mid + 1, right, newArray);

        // 辅助的 array
        for (int i = left; i <= right; i++) {
            newArray[i] = array[i];
        }

        // 「合」
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (newArray[i] <= newArray[j]) { // 等号会影响算法的稳定性
                array[k++] = newArray[i++];
            } else {
                array[k++] = newArray[j++];
            }
        }
        if (i <= mid) {
            array[k++] = newArray[i++];
        }
    }
}