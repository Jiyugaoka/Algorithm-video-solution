import java.util.Scanner;

public class pta1001 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 0;
        while (n!=1) {
            if ((n&1) == 1) {
                n = 3 * n + 1;
            }
            n /= 2;
            count ++ ;
        }
        System.out.println(count);
        input.close();
    }
}
