package test;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title QuickSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-02 11:05
 * @Version 1.0
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 7, 1, 3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int pivot = arr[left];

        while (i != j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        quickSort(arr, left, i - 1);
        quickSort(arr, j + 1, right);
    }
}
