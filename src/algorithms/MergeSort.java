package algorithms;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title MergeSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-01 22:28
 * @Version 1.0
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 7, 8, 1, 9, 0};
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

    public static void customDoubleMerge(int[] arr, int[] temp, int left, int mid, int right) {
        //定义三个指针
        int p1 = left, p2 = mid + 1, k = left;//k辅助数组开始指针
        while (p1 <= mid && p2 <= right) {//判断左右指针指向的数据
            if (arr[p1] < arr[p2]) {
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }
        while (p1 <= mid) {//左指针剩下的数据直接放入辅助数组
            temp[k++] = arr[p1++];
        }
        while (p2 <= right) {//右指针剩下的数据直接放入辅助数组
            temp[k++] = arr[p2++];
        }
        for (int i = left; i <= right; i++) {//将辅助数据的数据拷贝到原数组
            arr[i] = temp[i];
        }
    }
}
