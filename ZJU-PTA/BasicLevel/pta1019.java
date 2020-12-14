import java.util.*;
import java.io.*;

public class pta1019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().split(" ")[0]);
        String num1 = ascending(n), num2 = descending(n);

        if (num1.equals(num2)) {
            System.out.println(num1 + " - " + num2 + " = 0000");
            return ;
        }

        int temp = Integer.parseInt(num1) - Integer.parseInt(num2);

        if (temp > 0) {
            System.out.println(num1 + " - " + num2 + " = " + toLenthOf4(temp));
        } else {
            System.out.println(num2 + " - " + num1 + " = " + toLenthOf4(-temp));
            temp = -temp;
        }

        while (temp != 6174) {
            num1 = ascending(temp);
            num2 = descending(temp);

            if (num1.equals(num2)) {
                System.out.println(num1 + " - " + num2 + " = 0000");
                return ;
            }

            temp = Integer.parseInt(num1) - Integer.parseInt(num2);

            if (temp > 0) {
                System.out.println(num1 + " - " + num2 + " = " + toLenthOf4(temp));
            } else {
                System.out.println(num2 + " - " + num1 + " = " + toLenthOf4(-temp));
                temp = -temp;
            }
        }
        bf.close();
    }

    private static String ascending(int num) {
        String ss = String.valueOf(num);
        int[] numbers = new int[4];
        int i = 0;
        while (i < 4 - ss.length()) {
            numbers[i] = 0;
            i++;
        }
        for (int j = i; j < i + ss.length(); j++) {
            numbers[j] = ss.charAt(j-i) - '0';
        }
        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 4; j++) {
            sb.append(numbers[j]);
        }
        return sb.toString();
    }

    private static String descending(int num) {
        String ss = String.valueOf(num);
        int[] numbers = new int[4];
        int i = 0;
        while (i < 4 - ss.length()) {
            numbers[i] = 0;
            i++;
        }
        for (int j = i; j < i + ss.length(); j++) {
            numbers[j] = ss.charAt(j-i) - '0';
        }
        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (int j = 3; j >= 0; j--) {
            sb.append(numbers[j]);
        }
        return sb.toString();
    }

    private static String toLenthOf4(int num) {
        String ss = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4 - ss.length(); i++) {
            sb.append(0);
        }
        sb.append(num);
        return sb.toString();
    }
}
