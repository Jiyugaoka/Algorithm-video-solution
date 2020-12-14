import java.util.*;

public class pta1013 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, num = 2;
        int M = input.nextInt(), N = input.nextInt();
        while (true) {
            if (isPrime(num)){
                count++;
                if (count >= M && count < N) {
                    if ((count - M) % 10 < 9) {
                        System.out.print(num + " ");
                    } else {
                        System.out.println(num);
                    }
                }
                if (count == N) {
                    System.out.print(num);
                }
                if (count > N) {
                    break;
                }
            }
            if (num < 5) {
                num++;
            } else {
                num+=2;
            }
        }
        input.close();
    }

    private static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        for (int i = 5; i <= (int)Math.sqrt(n) ; i+=6) {
            if (n % i == 0 || n % (i+2) == 0) {
                return false;
            }
        }
        return true;
    }
}
