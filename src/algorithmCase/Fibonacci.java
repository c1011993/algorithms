package algorithmCase;

/**
 * @program: algorithms
 * @Title Fibonacci
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-03 11:44
 * @Version 1.0
 **/
public class Fibonacci {
    public static void main(String[] args) {
        long fibonacci = fibonacci(10);
        System.out.println(fibonacci);
    }

    static long fibonacci(long number) {
        if ((number == 0) || (number == 1)) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
