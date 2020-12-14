import java.util.*;

public class pta1006 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        StringBuilder res = new StringBuilder();
        String numString = Integer.toString(num);
        switch (numString.length()) {
            case 3:
                for (int j = 0; j < numString.charAt(0) - '0'; j++) {
                    res.append("B");
                }
                for (int i = 0; i < numString.charAt(1) - '0'; i++) {
                    res.append("S");
                }
                for (int i = 0; i < numString.charAt(2) - '0'; i++) {
                    res.append(i + 1);
                }
                break;
            case 2:
                for (int i = 0; i < numString.charAt(0) - '0'; i++) {
                    res.append("S");
                }
                for (int i = 0; i < numString.charAt(1) - '0'; i++) {
                    res.append(i + 1);
                }
                break;
            default:
                for (int i = 0; i < numString.charAt(0) - '0'; i++) {
                    res.append(i + 1);
                }
                break;
        }
        System.out.println(res.toString());
        input.close();
    }
}
