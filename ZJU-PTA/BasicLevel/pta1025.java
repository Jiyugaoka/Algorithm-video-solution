import java.util.*;
import java.io.*;

public class pta1025 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().split("\\s+");
        String head = info[0];
        int N = Integer.parseInt(info[1]), K = Integer.parseInt(info[2]);
        Map<String, Node> map = new HashMap<>();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            info = bf.readLine().split("\\s+");
            String cur = info[0];
            int val = Integer.parseInt(info[1]);
            String next = info[2];
            Node node = new Node(val, next);
            map.put(cur, node);
        }
        String cur = head;
        int ind = 0;
        for (int i = 0; i < N / K * K; i++) {
            if (i > ind + K - 1) {
                ind = ind + K;
            }
            list.add(ind, cur);
            cur = map.get(cur).next;
        }
        for (int i = 0; i < N % K; i++) {
            list.add(cur);
            cur = map.get(cur).next;
        }
        for (int i = 0; i < N; i++) {
            cur = list.get(i);
            int val = map.get(cur).val;
            String next = i == N - 1 ? "-1": list.get(i + 1);
            System.out.println(cur + " " + val + " " + next);
        }
        bf.close();
    }

    public static class Node {
        int val;
        String next;
        public Node(int val, String next) {
            this.val = val;
            this.next = next;
        }
    }
}
