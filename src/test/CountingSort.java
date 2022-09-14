package test;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title CountingSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-02 23:14
 * @Version 1.0
 **/
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 7, 1, 3, 8, 1, 10};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void countingSort(int[] arr) {
        int min = 0, max = 0;
        for (int value : arr) {
            if (value < min) {
                min = value;
            } else if (value > max) {
                max = value;
            }
        }
        //
        int range = max - min + 1;
        int[] count = new int[range];
        //
        for (int value : arr) {
            count[value - min]++;
        }
        //
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = arr[i] - min;
            count[index]--;
            result[count[index]] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }
}
