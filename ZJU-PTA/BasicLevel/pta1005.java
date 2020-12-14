import java.util.*;

public class pta1005 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int K = input.nextInt();
        int[] nums = new int[K];
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            nums[i] = input.nextInt();
            map.put(nums[i], false);
        }
        for (int i = 0; i < K; i++) {
            if (map.get(nums[i])) continue;
            int curNum = nums[i];
            while (curNum > 1) {
                if ((curNum & 1) == 1) curNum = 3 * curNum + 1;
                curNum /= 2;
                if (map.containsKey(curNum)) {
                    map.put(curNum, true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry: map.entrySet()) {
            Integer key = entry.getKey();
            Boolean val = entry.getValue();
            if (!val) {
                res.add(key);
            }
        }
        Collections.sort(res, Collections.reverseOrder());
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.print(res.get(res.size() - 1));
        input.close();
    }
}
