package algorithms;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title QuickSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-02 10:42
 * @Version 1.0
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 7, 3, 6, 1, 4};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        //结束递归条件
        if (left > right) {
            return;
        }
        //设置基准点
        //{5, 2, 7, 3, 6, 1, 4}
        int pivot = arr[left];
        //保留left right 保证下面的递归能正确找到相应的位置
        int i = left;
        int j = right;
        while (i != j) {
            //寻找右边比基准值小的
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            //寻找左边比基数大的
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            //将找到的左边比基准数大的数和右边比基准数小的数交换
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //{5, 2, 7, 3, 6, 1, 4}
        //pivot=arr[left]，此时arr[i]一定比基准值arr[left]小，互换，把较小的值作为下一轮比较的pivot
        //把最小值给到arr[left]，原来的pivot已经不是最小值了，赋给arr[i]
        arr[left] = arr[i];
        arr[i] = pivot;
        //递归
        quickSort(arr, left, i-1);
        quickSort(arr, j+1, right);
    }
}
