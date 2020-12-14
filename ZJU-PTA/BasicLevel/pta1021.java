import java.io.*;
import java.util.*;

public class pta1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine().split(" ")[0];
        int[] nums = new int[10];
        for (char c:
             num.toCharArray()) {
            nums[c-'0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (nums[i] > 0) {
                System.out.println(i + ":" + nums[i]);
            }
        }
    }
}
