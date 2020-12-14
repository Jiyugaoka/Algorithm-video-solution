import java.util.*;

public class pta1012 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int res1 = 0;
        int res2 = 0;
        float res4 = 0;
        int res5 = 0;
        int count2 = -1;
        boolean flag = false;
        int count3 = 0;
        int count4 = 0;
        int N = input.nextInt();
        for (int i = 0; i < N; i++) {
            int num = input.nextInt();
            if (num % 10 == 0) {
                res1 += num;
            }
            if (num % 5 == 1) {
                flag = true;
                count2 *= -1;
                res2 += count2 * num;
            }
            if (num % 5 == 2) {
                count3++;
            }
            if (num % 5 == 3) {
                count4++;
                res4 += num;
            }
            if (num % 5 == 4) {
                if (num > res5) {
                    res5 = num;
                }
            }
        }
        if (res1 > 0) {
            System.out.print(res1 + " ");
        } else {
            System.out.print("N ");
        }
        if (flag) {
            System.out.print(res2 + " ");
        } else {
            System.out.print("N ");
        }
        if (count3 > 0) {
            System.out.print(count3 + " ");
        } else {
            System.out.print("N ");
        }
        if (count4 > 0) {
            System.out.print(String.format("%.1f", res4/count4) + " ");
        } else {
            System.out.print("N ");
        }
        if (res5 > 0) {
            System.out.print(res5);
        } else {
            System.out.print("N");
        }
        input.close();
    }
}
