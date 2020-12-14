import java.util.*;

public class pta1011 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        for (int i = 1; i <= N; i++) {
            long A = input.nextInt(), B = input.nextInt(), C = input.nextInt();
            System.out.print("Case #" + i + ": ");
            System.out.println(A+B>C);
        }
        input.close();
    }
}
