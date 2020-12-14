import org.junit.Test;

import java.io.*;
import java.util.*;

public class pta1022 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = bf.readLine().split(" ");
        int num1 = Integer.parseInt(nums[0]), num2 = Integer.parseInt(nums[1]), D = Integer.parseInt(nums[2]);
        int sum = num1 + num2;
        System.out.println(Integer.toString(sum, D));
    }

    private static int otherToTen(String num, int radix) {
        num = num.toLowerCase();
        int res = 0;
        for (int i = 0; i < num.length(); i++) {
            int temp = num.charAt(i) >= 'a'? num.charAt(i) - 'a' + 10: num.charAt(i) - '0';
            res = radix * res + temp;
        }
        return res;
    }

    String tenToOther(int num, int radix) {
        StringBuilder sb = new StringBuilder();
        int Q = num / radix;
        char R = (num % radix) < 10 ? (char)(num % radix + '0'): (char)(num % radix - 10 + 'a') ;
        sb.append(R);
        while (Q != 0) {
            num = Q;
            Q = num / radix;
            R = (num % radix) < 10 ? (char)(num % radix + '0'): (char)(num % radix - 10 + 'a');
            sb.append(R);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test(){
        int num = 1234, d = 13;
        String numS1 = Integer.toString(num, d);
        String numS2 = tenToOther(num, d);

        System.out.println(numS1);
        System.out.println(numS2);

        int num1 = Integer.parseInt(numS1, d);
        int num2 = otherToTen(numS2, d);
        System.out.println(num1);
        System.out.println(num2);
    }
}
