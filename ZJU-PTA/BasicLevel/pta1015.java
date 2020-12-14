import java.io.*;
import java.util.*;

public class pta1015 {
    private static class Student {
        public int number;
        public int score1;
        public int score2;
        public int sum;
        public int level;

        public Student(int n, int s1, int s2, int level) {
            this.number = n;
            this.score1 = s1;
            this.score2 = s2;
            this.sum = s1 + s2;
            this.level = level;
        }

        @Override
        public String toString() {
            return number+ " " + score1 + " " + score2;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().split(" ");
        int N = Integer.parseInt(info[0]), L = Integer.parseInt(info[1]), H = Integer.parseInt(info[2]);
        Student[] students = new Student[N];
        int M = 0;
        for (int i = 0; i < N; i++) {
            info = bf.readLine().split(" ");
            int n = Integer.parseInt(info[0]), s1 = Integer.parseInt(info[1]), s2 = Integer.parseInt(info[2]);
            int level = 5;
            if (s1 >= L && s2 >= L) {
                M++;
                if (s1 >= H && s2 >= H) {
                    level = 1;
                } else if (s1 >= H && s2 < H) {
                    level = 2;
                } else if (s1 < H && s2 < H && s1 >= s2) {
                    level = 3;
                } else {
                    level = 4;
                }
            }
            students[i] = new Student(n, s1, s2, level);
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 按照等级升序
                if (o1.level != o2.level) {
                    return o1.level - o2.level;
                }
                    // 按照总分降序
                else if (o1.sum != o2.sum) {
                    return o2.sum - o1.sum;
                }
                    // 按照德育分降序
                else if (o1.score1 != o2.score1) {
                    return o2.score1 - o1.score1;
                }
                    // 按照序号升序
                else {
                    return o1.number - o2.number;
                }
            }
        });

        System.out.println(M);

        for (int i = 0; i < M; i++) {
            System.out.println(students[i]);
        }
    }
}


//import java.util.*;
//
//public class pta1015 {
//
//    private static class Student {
//        private int number;
//        private int score1;
//        private int score2;
//
//        public Student(int n, int s1, int s2) {
//            this.number = n;
//            this.score1 = s1;
//            this.score2 = s2;
//        }
//
//        public int getNumber() {
//            return number;
//        }
//
//        public int getScore1() {
//            return score1;
//        }
//
//        public int getScore2() {
//            return score2;
//        }
//
//        public int getSum() {
//            return score1 + score2;
//        }
//
//        @Override
//        public String toString() {
//            return getNumber()+ " " + getScore1() + " " +getScore2();
//        }
//    }
//
//    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        int N = input.nextInt(), L = input.nextInt(), H = input.nextInt();
//        Map<Integer, List> group = new HashMap<>();
//        List<Student> ss;
//        int M = 0;
//        for (int i = 0; i < N; i++) {
//            int n = input.nextInt(), s1 = input.nextInt(), s2 = input.nextInt();
//            if (s1 >= L && s2 >= L) {
//                M++;
//                if (s1 >= H && s2 >= H) {
//                    ss =  group.getOrDefault(1, new ArrayList<>());
//                    ss.add(new Student(n, s1, s2));
//                    group.put(1, ss);
//                }
//                else if (s1 >= H && s2 < H) {
//                    ss =  group.getOrDefault(2, new ArrayList<>());
//                    ss.add(new Student(n, s1, s2));
//                    group.put(2, ss);
//                }
//                else if (s1 < H && s2 < H && s1 >= s2) {
//                    ss =  group.getOrDefault(3, new ArrayList<>());
//                    ss.add(new Student(n, s1, s2));
//                    group.put(3, ss);
//                }
//                else {
//                    ss =  group.getOrDefault(4, new ArrayList<>());
//                    ss.add(new Student(n, s1, s2));
//                    group.put(4, ss);
//                }
//            }
//        }
//        System.out.println(M);
//
//        // 按照总分降序排序
//        Comparator cmp1 = Comparator.comparing(Student::getSum).reversed();
//        // 按照德育分降序排序
//        Comparator cmp2 = Comparator.comparing(Student::getScore1).reversed();
//        // 按照学号升序排序
//        Comparator cmp3 = Comparator.comparing(Student::getNumber);
//
//        for (int i = 1; i <= 4; i++) {
//            ss = group.get(i);
//            if (ss != null) {
//                ss.stream().sorted(cmp1.thenComparing(cmp2).thenComparing(cmp3)).forEach(System.out::println);
//            }
//        }
//        input.close();
//    }
//}

/* C++可以通过
#include <iostream>
#include <algorithm>
using namespace std;
struct node{
    int number;
    int de,cai,sum;
    int t;
}num[100000];
bool cmp(node a,node b)//优先级：类别-总分-品德分-学号
{
    if(a.t!=b.t)return a.t<b.t;
    else if(a.sum!=b.sum)return a.sum>b.sum;
    else if(a.de!=b.de)return a.de>b.de;
    else return a.number<b.number;
}
int main(){
    int n,l,h,k=0;
    scanf("%d %d %d",&n,&l,&h);
    for(int i=0;i<n;i++)
    {
        scanf("%d %d %d",&num[i].number,&num[i].de,&num[i].cai);
        num[i].sum=num[i].de+num[i].cai;
        if(num[i].de<l||num[i].cai<l)num[i].t=5;//不被录取的
        else{
            k++;
            if(num[i].de>=h&&num[i].cai>=h)num[i].t=1;
            else if(num[i].de>=h&&num[i].cai>=l)num[i].t=2;
            else if(num[i].de>=num[i].cai)num[i].t=3;
            else num[i].t=4;
        }
    }
    sort(num,num+n,cmp);
    printf("%d\n",k);
    for(int i=0;i<k;i++)
    {
        printf("%d %d %d\n",num[i].number,num[i].de,num[i].cai);
    }
    return 0;
}
*/
