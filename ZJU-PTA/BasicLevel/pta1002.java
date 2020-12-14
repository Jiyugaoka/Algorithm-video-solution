import java.util.*;

public class pta1002 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num = input.next();
        int res = 0;
        HashMap<Character,String> juge=new HashMap<>();
        juge.put('0',"ling");
        juge.put('1',"yi");
        juge.put('2',"er");
        juge.put('3',"san");
        juge.put('4',"si");
        juge.put('5',"wu");
        juge.put('6',"liu");
        juge.put('7',"qi");
        juge.put('8',"ba");
        juge.put('9',"jiu");
        for (int i = 0; i < num.length(); i++) {
            res += (num.charAt(i) - '0');
        }
        System.out.println(res);
        String sum = Integer.toString(res);
        for (int i = 0; i < sum.length() - 1; i++) {
            System.out.print(juge.get(sum.charAt(i))+" ");
        }
        System.out.print(juge.get(sum.charAt(sum.length() - 1)));
        input.close();
    }
}


