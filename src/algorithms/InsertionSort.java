package algorithms;

/**
 * @program: algorithms
 * @Title InsertionSort
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-01 17:08
 * @Version 1.0
 **/
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 8, 7,};
        //{1, 1, 1, 1, 1, 9}
        //原理：{5, 7, 8, 2, 1, 9}
        //把第一个元素当作已排序的序列，后边的当作未排序的
        //第二个元素与第一个元素比较，放到合适的位置
        //第三个元素与前两个元素比较，放到合适的位置
        for (int i = 1; i < arr.length; i++) {
            int insertedValue = arr[i];//待插入的值
            int j = i - 1;//待插入的值前面的那个值的索引
            //每当数组里面要比较的数大于待插入的数 就把insertindex的下标减一（insertindex刚开始就是待插入的数的前一位的下标j）
            // 这样下一次循环就可以跟前面一个数比较了 然后把刚比较完的数往后移一位
            //发现前一个比要插入的值大的就把前一个的值复制给后一个，以此类推，相当于一直往后移动，直到arr[j]不大于insertedValue，
            //把指针往前挪一个把insertedValue赋值
            while (j >= 0 && arr[j] > insertedValue) {
                //此时待插入值的前一个值 大于 待插入值
                //前一个值赋给待插入值的索引位置，但是待插入之insertedValue没有改变
                //比较原始待插入值得前前个索引位置的值，要是还大于待插入值，就把前前索引的值赋给前索引
                //继续这样比较，直到找到小于等于待插入值得位置 退出循环，退出之前j-1；
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = insertedValue;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
