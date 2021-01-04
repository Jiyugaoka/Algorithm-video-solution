import java.util.*;
import java.io.*;

class PTA1094 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().trim().split("\\s+");
        int N = Integer.parseInt(line[0]), M = Integer.parseInt(line[1]);
        Map<String, String[]> data = new HashMap<>();
        Map<Integer, String[]> res = new HashMap<>();
        res.put(1, new String[]{"01"});
        for (int i = 0; i < M; i++) {
            line = bf.readLine().trim().split("\\s+");
            int n = Integer.parseInt(line[1]);
            String[] temp = new String[n];
            for (int j = 0; j < n; j++) {
                temp[j] = line[j + 2];
            }
            data.put(line[0], temp);
        }
        for (int i = 2; i <= N; i++) {
            String[] levelData = res.get(i - 1);
            List<String> tempLevel = new ArrayList<>();
            for (String s1: levelData) {
                for (String s2: data.getOrDefault(s1, new String[0])) {
                    tempLevel.add(s2);
                }
            }
            res.put(i, tempLevel.toArray(new String[0]));
            if (tempLevel.size() == 0) break;
        }
        int res1 = 0, res2 = 0;
        for (Map.Entry<Integer, String[]> entry: res.entrySet()) {
            if (entry.getValue().length > res1) {
                res1 = entry.getValue().length;
                res2 = entry.getKey();
            }
        }
        System.out.println(res1 + " " + res2);
    }
}