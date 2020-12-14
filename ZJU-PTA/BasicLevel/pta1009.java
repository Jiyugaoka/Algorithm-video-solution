import java.util.*;

public class pta1009 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // nextLine一次读取一行， next一次只读一个单词，遇到空格和回车停止。
        String sentences = input.nextLine();
        String[] res = sentences.split(" ");
        for (int i = res.length-1; i>0; i--) {
            System.out.print(res[i] + " ");
        }
        System.out.println(res[0]);
        input.close();
    }
}
