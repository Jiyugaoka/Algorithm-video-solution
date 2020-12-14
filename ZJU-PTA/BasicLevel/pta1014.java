import java.util.*;

public class pta1014 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] week = {"MON ", "TUE ", "WED ", "THU ", "FRI ", "SAT ", "SUN "};

        String s1 = input.nextLine();
        String s2 = input.nextLine();
        String s3 = input.nextLine();
        String s4 = input.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                if (sb.length() == 0) {
                    if (s1.charAt(i) >= 'A' && s1.charAt(i) <= 'G') {
                        sb.append(week[s1.charAt(i)-'A']);
                        continue;
                    }
                }
                if (sb.length() > 0) {
                    if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                        sb.append(0).append(s1.charAt(i) - '0').append(":");
                        break;
                    }
                    if (s1.charAt(i) >= 'A' && s1.charAt(i) <= 'N') {
                        sb.append(s1.charAt(i) - 'A' + 10).append(":");
                        break;
                    }

                }
            }
        }
        for (int i = 0; i < Math.min(s3.length(), s4.length()); i++) {
            if (s3.charAt(i) == s4.charAt(i)) {
                if ((s3.charAt(i) >= 'A' && s3.charAt(i) <= 'Z') || (s3.charAt(i) >= 'a' && s3.charAt(i) <= 'z')) {
                    if (i < 10) {
                        sb.append(0).append(i);
                    } else {
                        sb.append(i);
                    }
                    break;
                }
            }
        }
        System.out.println(sb.toString());
        input.close();
    }
}
