package test;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title MergeSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-01 23:23
 * @Version 1.0
 **/
public class MergeSort {
    public static void main(String[] args) {
       /* int[] arr = {1, 5, 8, 2, 3, 9, 4};
        int[] temp = new int[arr.length];
        customMergeSort(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));*/
        int[] arr = new int[]{5, 2, 7, 1, 3, 6, 3, 1, 2, 3, 4, 5};
        int[] temp = new int[arr.length];
        customMergeSort(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void customMergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {//递归条件结束，一个为一组时
             int mid = (start + end) / 2;//分界点
            customMergeSort(arr, temp, start, mid);//排序 左子组
            customMergeSort(arr, temp, mid + 1, end);//排序 右子组
            customDoubleMerge(arr, temp, start, mid, end);//合并
        }
    }

    private static void customDoubleMerge(int[] arr, int[] temp, int left, int mid, int right) {

        int p1 = left, p2 = mid + 1, k = left;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            temp[k++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[k++] = arr[p2++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

    }
}
