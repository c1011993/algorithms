package test;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title SelectionSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-01 16:35
 * @Version 1.0
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] num = new int[]{7, 5, 8, 2, 3, 9, 6};
        for (int i = 0; i < num.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j]<num[minIndex]){
                    minIndex = j;
                }
            }
            if (i!=minIndex){
                int temp = num[i];
                num[i] = num[minIndex];
                num[minIndex] = temp;
            }
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }
    }
}
