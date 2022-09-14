package algorithms;

import java.util.Arrays;

/**
 * @program: algorithms
 * @Title HeapSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-02 15:00
 * @Version 1.0
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 7, 1, 3, 8, 1, 10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        //形成大顶堆树
        // i是第一个非叶子节点的索引值(一个子树的根)，index--，得到其他的非叶子节点的索引值，直到0
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //目的是从树上按照顺序取出元素放进数组
        //从最右边最下边的值开始，依次与顶端值交换，每交换一次就重新排序一次
        //0表示根部节点的值，i表示最后一个节点的值
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            //重新形成大顶堆树
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        //temp此时表示一个父节点a,此时的i指向它
        int temp = arr[i];
        //2*i+1表示这个父节点的左子节点La
        //k = k * 2 + 1表示如果这个父节点的子节点仍有子节点b，此时的k表示La，即为新的父节点La 相对于c的
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            //k + 1 < length 判断b是否有右子节点Lb
            //arr[k] < arr[k + 1] 右子节点Lb是否大于左子节点La
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //若上述条件成立，则k指向较大值的那个索引位置
                k++;
            }
            //此时k所在的位置就是这个子树La，Lb中的最大值的索引位置
            //若这个最大值比它的父节点a大，把较大值赋给a节点
            //并把i指针指向k
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
                //把原父节点a的值赋给原来k指向的位置
                arr[i] = temp;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
