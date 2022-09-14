package algorithms;

/**
 * @program: algorithms
 * @Title SelectionSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-01 16:12
 * @Version 1.0
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 8, 2};
        //第一轮比较，确定最左边的最小值，从第一个索引处的值开始
            //设minIndex=0是最小值的索引，比较index=1与minIndex=0处的值大小，7>5, minIndex=1;
            //index=2与minIndex处的值比较，minIndex=1
            //index=3与minIndex处的值比较，minIndex=3
            //循环比较结束后，将minIndex=3的值与index=0的值互换 2 5 8 7
        //第二轮比较，确定左边第二小的值，从第二个索引处的值开始
            //设minIndex=1, index=2与minIndex的值比
            //
            //
        //第三轮比较


        for (int i = 0; i < arr.length - 1; i++) {
            //设index=i为最小值索引
            int minIndex = i;
            //遍历i之后的值，如果小于arr[i]，就把最小值的索引minIndex指向它
            //此时后面在进行比较时，针对的就是这个最小值的索引 不是i索引了
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    //获取最小值的索引
                    minIndex = j;
                }
            }
            //如果找到的最小值的索引minIndex不是原来的i
            //就进行调换他俩的值
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            //结束一轮循环，此时minIndex指向的i仍然是最小值
            //继续比较
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
