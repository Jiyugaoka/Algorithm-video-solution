import java.util.*;
import java.io.*;

public class pta1023 {
    public static void main(String[] args) throws  IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < Integer.parseInt(input[i]); j++) {
                nums.add(i);
            }
        }
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        if (nums.get(0)==0) {
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) > 0) {
                    nums.set(0, nums.get(i));
                    nums.set(i, 0);
                    break;
                }
            }
        }
        for (Integer n: nums) {
            System.out.print(n);
        }
    }
}
