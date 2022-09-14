package test;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title ShellSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-01 22:14
 * @Version 1.0
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 7, 8, 1, 9};
        for (int gap = arr.length/2; gap >0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int insertedValue = arr[i];
                int j = i - gap;
                while (j >=0 && arr[j] >= insertedValue) {
                    arr[j + gap] = arr[j];
                    j-=gap;
                }
                arr[j+gap] = insertedValue;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
