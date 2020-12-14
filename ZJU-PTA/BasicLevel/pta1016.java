import java.util.*;

public class pta1016 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String A = input.next();
        int Da = input.nextInt();
        String B = input.next();
        int Db = input.nextInt();
        int[] mapA = new int[10];
        int[] mapB = new int[10];
        for (int i = 0; i < A.length(); i++) {
            mapA[A.charAt(i) - '0']++;
        }
        for (int i = 0; i < B.length(); i++) {
            mapB[B.charAt(i) - '0']++;
        }
        int Pa = 0, Pb = 0;
        while (mapA[Da]-- > 0) {
            Pa = 10 * Pa + Da;
        }
        while (mapB[Db]-- > 0) {
            Pb = 10 * Pb + Db;
        }
        System.out.println(Pa+Pb);
        input.close();
    }
}
