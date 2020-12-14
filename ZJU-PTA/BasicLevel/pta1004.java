import java.util.*;

public class pta1004 {

    public static void main(String[] args) {
        int maxInd = 0, minInd = 0;
        int maxNum = -1, minNum = 101;
        List<String> names = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int i = 0;
        while (i < n) {
            names.add(input.next());
            numbers.add(input.next());
            int curNum = input.nextInt();
            if (minNum > curNum) {
                minNum = curNum;
                minInd = i;
            }
            if (maxNum < curNum) {
                maxNum = curNum;
                maxInd = i;
            }
            i++;
        }
        System.out.println(names.get(maxInd) + " " + numbers.get(maxInd));
        System.out.println(names.get(minInd) + " " + numbers.get(minInd));
        input.close();
    }
}
