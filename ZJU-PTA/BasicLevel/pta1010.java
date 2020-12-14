import java.util.*;

public class pta1010 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (input.hasNext()) {
            int a = input.nextInt(), b = input.nextInt();
            if (b != 0) {
                sb.append(a*b + " " + (b-1) + " ");
            }
        }
        String res = sb.toString();
        if (res.length() == 0) {
            System.out.println("0 0");
        } else {
            System.out.println(res.trim());
        }
        input.close();
    }
}
