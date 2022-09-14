package test;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title RadixSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-03 11:04
 * @Version 1.0
 **/
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{98421, 240, 1153549999, 532, 305, 430, 124};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int[] count = new int[10];
        int[] result = new int[arr.length];

        int maxFigure = 0;
        for (int value : arr) {
            int figure = (value + "").length();
            if (figure > maxFigure) {
                maxFigure = figure;
            }
        }
        for (int i = 0; i < maxFigure; i++) {
            int division = (int) Math.pow(10, i);
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] / division % 10;
                count[num]++;
            }
            for (int m = 1; m < count.length; m++) {
                count[m] += count[m - 1];
            }
            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / division % 10;
                result[--count[num]] = arr[n];
            }
            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }
    }
}
