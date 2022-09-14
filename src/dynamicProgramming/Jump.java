package dynamicProgramming;

/**
 * @program: algorithms
 * @Title ClimbingStairs
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-03 15:10
 * @Version 1.0
 **/

/**
 * 动态规划解体思路
 * 确定本题的数组如何建
 * 推导出本题的公式
 * 进行循环
 */
public class Jump {
    public static void main(String[] args) {
        System.out.println(jump(6));
    }

    static int jump(int n) {
        if ((n == 0) || (n == 1)) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[0] = 0;
            dp[1] = 1;
            dp[i] = 2 * dp[i - 1];
        }
        return dp[n];
        //f(n)=f(n-1)+f(n-2)+f(n-3)+...+f(0)
        //f(n-1)=f(n-2)+f(n-3)+...+f(0)
        //f(n)-f(n-1)=f(n-1)
        //f(n)=2f(n-1)
    }
}
