package dailyTest;

import java.util.Arrays;


/**
 * @program: algorithms
 * @Title Algorithms
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-04 16:44
 * @Version 1.0
 **/
public class Day2 {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 8, 2, 9, 6};
        int[] arr1 = new int[]{1, 5, 8, 2, 8, 9, 6};
        System.out.println("1selectionSort " + Arrays.toString(selectionSort(arr1)));
        int[] arr2 = new int[]{1, 5, 8, 2, 8, 9, 6};
        System.out.println("2insertionSort " + Arrays.toString(insertionSort(arr2)));
        int[] arr3 = new int[]{1, 5, 8, 2, 8, 9, 6};
        System.out.println("3bubbleSort " + Arrays.toString(bubbleSort(arr3)));
        int[] arr4 = new int[]{1, 5, 8, 2, 8, 9, 6};
        System.out.println("4shellSort " + Arrays.toString(shellSort(arr4)));
        int[] arr5 = new int[]{1, 5, 8, 2, 8, 9, 6};
        System.out.println("5mergeSort " + Arrays.toString(mergeSort(arr5, new int[arr5.length], 0, arr5.length - 1)));
        int[] arr6 = new int[]{1, 5, 8, 2, 8, 9, 6};
        System.out.println("6quickSort " + Arrays.toString(quickSort(arr6, 0, arr6.length - 1)));
        int[] arr7 = new int[]{1, 5, 8, 2, 8, 9, 6};
        System.out.println("7heapSort " + Arrays.toString(heapSort(arr7)));
        int[] arr8 = new int[]{1, 5, 8, 2, 8, 9, 6};
        System.out.println("8countingSort " + Arrays.toString(countingSort(arr8)));
        int[] arr9 = new int[]{1, 5, 8, 2, 8, 9, 6};
        System.out.println("9radixSort " + Arrays.toString(radixSort(arr9)));
    }

    /**
     * 选择排序
     *
     * @param arr
     * @return
     */

    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * {7, 5, 8, 2, 9, 6}
     * {5, 7, 8, 2, 9, 6}
     * {5, 7, 2, 8, 9, 6}
     * {5, 2, 7, 8, 9, 6}
     * {2, 5, 7, 8, 9, 6}
     */

    static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int insertedValue = arr[i];
            while (j >= 0 && arr[j] > insertedValue) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertedValue;
        }
        return arr;
    }

    /**
     * 冒泡排序
     */
    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 希尔排序
     */

    static int[] shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i - gap;
                int temp = arr[i];
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                    arr[j + gap] = temp;
                }
            }
        }
        return arr;
    }


    /**
     * 归并排序
     */

    static int[] mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            doubleMerge(arr, temp, start, mid, end);
        }
        return arr;
    }

    static void doubleMerge(int[] arr, int[] temp, int left, int mid, int right) {
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
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * 快速排序
     */
    static int[] quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return arr;
        }
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = pivot;

        quickSort(arr, left, i - 1);
        quickSort(arr, j + 1, right);
        return arr;
    }

    /**
     * 堆排序
     */
    static int[] heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
                arr[i] = temp;
            } else {
                break;
            }
        }
    }

    /**
     * 计数排序
     */
    static int[] countingSort(int[] arr) {
        int max = 0, min = 0;
        for (int value : arr) {
            if (value > max) {
                max = value;
            } else if (value < min) {
                min = value;
            }
        }
        int range = max - min + 1;

        int[] count = new int[range];
        for (int value : arr) {
            count[value - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--count[arr[i] - min]] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
        return arr;
    }

    /**
     * 基数排序
     */
    static int[] radixSort(int[] arr) {
        int maxFigure = 0;
        for (int value : arr) {
            if ((value + "").length() > maxFigure) {
                maxFigure = (value + "").length();
            }
        }
        int[] count = new int[10];
        int[] result = new int[arr.length];
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
                result[--count[arr[n]/division%10]] = arr[n];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
        return arr;
    }
}




















