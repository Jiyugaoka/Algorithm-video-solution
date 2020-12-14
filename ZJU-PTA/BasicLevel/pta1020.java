import java.util.*;
import java.io.*;



public class pta1020 {

    public static class Mooncake {// 当作一个结构体来使用
        public double storage;
        public double pricePer;
        // 亲测构造函数中这两个参数如果使用int会有一个测试用力错误，我是真的找不到为啥子会这样。
        public Mooncake(double storage, double totalPrice) {
            this.storage = storage;
            this.pricePer = totalPrice / storage;
        }

        @Override
        public String toString() {
            return storage + " " + pricePer;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = bf.readLine().split(" ");
        int N = Integer.parseInt(ss[0]);
        double total = Double.parseDouble(ss[1]);

        String[] storgeSS = bf.readLine().split(" ");
        String[] priceSS = bf.readLine().split(" ");

        Mooncake[] cake = new Mooncake[N];
        for (int i = 0; i < N; i++) {
            // 如果不适用Double的话有一个测试用例会出错
            cake[i] = new Mooncake(Double.parseDouble(storgeSS[i]), Double.parseDouble(priceSS[i]));
        }

//        亲测使用lambda表达式写法会超时
//        Arrays.sort(cake, (o1, o2) -> o2.pricePer > o1.pricePer ? 1: o2.pricePer == o1.pricePer? 0: -1);
        Arrays.sort(cake, new Comparator<Mooncake>() {
            @Override
            public int compare(Mooncake o1, Mooncake o2) {
                if (o1.pricePer == o2.pricePer) {
                    return 0;
                } else if (o2.pricePer > o1.pricePer) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        double res = 0.0;

        for (int i = 0; i < N && total > 0; i++) {
            double temp = Math.min(total, cake[i].storage);
            res += temp * cake[i].pricePer;
            total -= temp;
        }
        System.out.printf("%.2f", res);
        bf.close();
    }
}
