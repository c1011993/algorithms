package test;

/**
 * @program: algorithms
 * @Title BubbleSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-01 16:10
 * @Version 1.0
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] num = new int[]{1, 5, 8, 2, 3, 9, 4};
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }
    }
}
