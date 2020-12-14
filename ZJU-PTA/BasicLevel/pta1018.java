import java.util.*;
import java.io.*;

public class pta1018 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(bf.readLine().split(" ")[0]);
        // 胜、负、平局
        int A0 = 0, A1 = 0, A2 = 0;
        int Ac = 0, Aj = 0, Ab = 0;
        int B0 = 0, B1 = 0, B2 = 0;
        int Bc = 0, Bj = 0, Bb = 0;
        while (N > 0) {
            String[] ss = bf.readLine().split(" ");
            char n1 = ss[0].toCharArray()[0], n2 = ss[1].toCharArray()[0];
            if (n1 - n2 == 7) { //"J-C" A负，B胜
                A1++;
                B0++;
                Bc++;
            } else if (n1 - n2 == -7) { // "C-J" A胜，B负
                A0++;
                B1++;
                Ac++;
            } else if (n1 - n2 == 1) { // "C-B" A负，B胜
                A1++;
                B0++;
                Bb++;
            } else if (n1 - n2 == -1) { // "B-C" A胜，B负
                A0++;
                B1++;
                Ab++;
            } else if (n1 - n2 == -8) { // "B-J" A负，B胜
                A1++;
                B0++;
                Bj++;
            } else if (n1 - n2 == 8) { // "J-B" A胜，B负
                A0++;
                B1++;
                Aj++;
            } else {
                A2++;
                B2++;
            }
            N--;
        }
        char resA;
        if (Ac >= Aj && Ac > Ab) {
            resA = 'C';
        } else if (Aj > Ac && Aj > Ab) {
            resA = 'J';
        } else {
            resA = 'B';
        }
        char resB;
        if (Bc >= Bj && Bc > Bb) {
            resB = 'C';
        } else if (Bj > Bc && Bj > Bb) {
            resB = 'J';
        } else {
            resB = 'B';
        }
        System.out.println(A0 + " " + A2 + " " + A1);
        System.out.println(B0 + " " + B2 + " " + B1);
        System.out.println(resA + " " + resB);
        bf.close();
    }
}
