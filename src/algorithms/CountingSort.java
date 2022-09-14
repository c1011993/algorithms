package algorithms;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title CountingSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-02 17:58
 * @Version 1.0
 **/
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 7, 1, 3, 8, 1, 10};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(int[] src) {
        // 数组中的最小值
        int min = 0;
        // 数组中的最大值
        int max = 0;
        for (int value : src) {
            if (value < min) {
                min = value;
            } else if (value > max) {
                max = value;
            }
        }

        // 数组中的数据范围
        int range = max - min + 1;
        // count[i]表示数组src中数据min + i的个数
        int[] count = new int[range];
        for (int value : src) {
            count[value - min]++;
        }

        // 累计，使得count[i]保存src中小于等于min + i的数据的个数
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // 结果数组
        int[] res = new int[src.length];
        // 倒序遍历原数组，保持排序的稳定性
        for (int i = src.length - 1; i >= 0; i--) {
            // 获取数据在count数组中的索引
            int index = src[i] - min;
            // 个数减1,因为count[index]也要当作索引，所以需要-1
            count[index]--;
            // 数据src[i]排序后的索引是count[index]
            res[count[index]] = src[i];
        }
        for (int i = 0; i < res.length; i++) {
            src[i] = res[i];
        }
    }
}
