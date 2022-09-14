package algorithmCase;

/**
 * @program: algorithms
 * @Title Jump
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-03 11:49
 * @Version 1.0
 **/
public class Jump {
    public static void main(String[] args) {
        System.out.println(jump(6));
    }

    static int jump(int number) {
        if ((number == 0) || (number == 1)) {
            return number;
        } else {
            //f(n)=f(n-1)+f(n-2)+f(n-3)+...+f(0)
            //f(n-1)=f(n-2)+f(n-3)+...+f(0)
            //f(n)-f(n-1)=f(n-1)
            //f(n)=2f(n-1)
            return 2 * jump(number - 1);
        }
    }
}
