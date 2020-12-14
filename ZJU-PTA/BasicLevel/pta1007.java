import java.util.*;

public class pta1007 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n <= 4) {
            System.out.println(0);
        } else {
            int res = 1;
            // 在大于等于5的质数均分布在6的倍数的左右，所以这写质数总是两两间隔2.
            for (int i = 5; i <= n-2; i += 6) {
                if (isPrime(i) && isPrime(i+2)) {
                    res++;
                }
            }
            System.out.println(res);
        }
        input.close();
    }

    private static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }
        // 不在6的两侧一定不是质数
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        for (int i = 5; i <= (int)Math.sqrt(n); i += 6) {
            if ((n % i) == 0 || (n % (i+2) == 0)) {
                return false;
            }
        }
        return true;
    }
}
