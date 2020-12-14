import java.util.*;

public class pta1008 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        m = m % n;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        for (int i = n - m; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        for (int i = 0; i < n-m-1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print(nums[n-m-1]);
        input.close();
    }
}
