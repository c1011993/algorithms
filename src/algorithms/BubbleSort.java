package algorithms;

/**
 * @program: algorithms
 * @Title BubbleSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-01 15:54
 * @Version 1.0
 **/
public class BubbleSort {
    public static void main(String[] args) {

//        int[] num = new int[]{1, 5, 8, 2, 3, 9, 4};
        int[] num = new int[]{8, 3, 9, 4};
        //第一次冒泡,确定最后一位
            //3 8 9 4
            //3 8 9 4
            //3 8 4 9
        //第二次冒泡，确定倒数第二位
            //3 8 4 9
            //3 4 8 9
        //第三次冒泡，确定倒数第三位
            //3 4 8 9
        //进行num.length-1次冒泡
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
            System.out.print(num[i] + " ");
        }
    }
}
