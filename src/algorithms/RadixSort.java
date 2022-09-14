package algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: algorithms
 * @Title BucketSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-02 23:45
 * @Version 1.0
 **/
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{911, 24021, 11};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //算出最大的长度maxFigure
        int maxFigure = 0;
        for (int value : arr) {
            if ((value + "").length() > maxFigure) {
                maxFigure = (value + "").length();
            }
        }
        //count是0-9这是个数字的长度，用来存储
        int[] count = new int[10];
        int[] result = new int[arr.length];
        //对每一位（个十百千）进行遍历
        for (int i = 0; i < maxFigure; i++) {
            //10的i次方
            int division = (int) Math.pow(10, i);
            //这一个循环下来，把个位数的0-9中出现的次数都存在了对应的空间里面
            for (int j = 0; j < arr.length; j++) {
                //假设值为321，i=0,division=1,num=1
                //假设值为321，i=1,division=10,num=2
                //假设值位321，i=2，division=100，num=3
                //在经过/division后只剩下个位数，再%10
                int num = arr[j] / division % 10;
                count[num]++;
            }
            for (int m = 1; m < count.length; m++) {
                count[m] += count[m - 1];
            }
            //把原数组倒序的放进result数组中去（按照个十百千位数去执行）
            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / division % 10;
                result[--count[num]] = arr[n];
            }
            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }
    }
}
