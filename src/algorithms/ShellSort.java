package algorithms;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title ShellSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-01 21:05
 * @Version 1.0
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 8, 2, 1, 9};
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i - gap;//j是理论分组中的前一个元素的index
                int temp = arr[i];
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                    arr[j + gap] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
