package test;

import java.util.Arrays;


/**
 * @program: algorithms
 * @Title HeapSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-02 17:29
 * @Version 1.0
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 7, 1, 3, 8, 1, 10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i > 0; i--) {
            adjustHeap(arr, 0, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k <length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
                arr[i] = temp;
            }else {
                break;
            }
        }
    }
}
