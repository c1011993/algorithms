package test;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title InsertionSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-01 20:58
 * @Version 1.0
 **/
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 8, 2, 1, 9};

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];//i表示待插入的值的index
            int j = i - 1;
            while (j >= 0 && arr[j] >= temp) {
                arr[i--] = arr[j];
                arr[j--] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
