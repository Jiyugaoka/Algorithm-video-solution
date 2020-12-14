import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class pta1017 {
    public static void main(String[] args) throws IOException{

//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String[] ss = bf.readLine().split(" ");
//        char[] A = ss[0].toCharArray();
//        int B = Integer.parseInt(ss[1]);
////        Scanner input = new Scanner(System.in);
////        String A = input.next();
////        int B = input.nextInt();
////        StringBuilder sb = new StringBuilder();
//        int len = A.length;
//        int Q = (A[0] - '0') / B;
//        // 若是商超过两位则首位不能为0.
//        if (len == 1 || len > 1 && Q > 0) {
////            sb.append(Q);
//            System.out.print(Q);
//        }
//        int R = (A[0] - '0') % B;
//        for (int i = 1; i < len; i++) {
//            Q = (10 * R + A[i] - '0') / B;
//            R = (10 * R + A[i] - '0') % B;
////            sb.append(Q);
//            System.out.print(Q);
//        }
////        System.out.println(sb.toString()+" "+R);
////        input.close();
//        System.out.println(" " + R);
//        bf.close();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = bf.readLine().split(" ");
        BigInteger A = new BigInteger(ss[0]);
        BigInteger B = new BigInteger(ss[1]);
        BigInteger[] res = A.divideAndRemainder(B);
        System.out.println(res[0] + " " + res[1]);
    }
}
