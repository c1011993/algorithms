package dynamicProgramming;

/**
 * @program: algorithms
 * @Title Fibonacci
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-03 12:27
 * @Version 1.0
 **/
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(3));
    }

    static int fibonacci(int n) {
        if ((n == 0) || (n == 1)) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
