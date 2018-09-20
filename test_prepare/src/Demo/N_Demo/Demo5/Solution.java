package Demo.N_Demo.Demo5;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static class Person implements Comparable<Person>{
        private int point = 0;
        private int sex = 0;
        private int age = 0;
        private int diss = 0;

        public Person(int sex, int age, int diss , int[] rateArr) {
            this.sex = sex;
            this.age = age;
            this.diss = diss;
            if(age <= 7)
                age = 200- age;
            this.point = sex*rateArr[1] + age*rateArr[2] + diss*rateArr[3];
        }

        @Override
        public int compareTo(Person o) {
            return o.point - this.point;
        }
    }


    enum SexEnum {S,M,F};
    enum DissEnum {D,P,DP,PW};


    public static void solution() {
        Scanner sc  = new Scanner(System.in);
        int[] rateArr = new int[4];6

        for(int i = 2; i >= 0; i--) {
            rateArr[sc.nextInt()] = (int)Math.pow(1000,i);
        }

        Queue<Person> que = new PriorityQueue<>();
        int cnt = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < cnt; i++) {
            String[] split = sc.nextLine().split(" ");
            int sex = SexEnum.valueOf(split[0]).ordinal();
            int age = Integer.parseInt(split[1]);
            int diss = 0;
            if(split.length == 3){
                diss = DissEnum.valueOf(split[2]).ordinal();
            }
            Person p = new Person(sex,age,diss,rateArr);
            que.offer(p);
        }

        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()) {
            Person p = que.poll();
            sb.append(SexEnum.values()[p.sex] + " ");
            sb.append(p.age + " ");
            if(p.diss != 0)
                sb.append(DissEnum.values()[p.diss]);
            sb.append("\n");
        }

        System.out.println(sb.toString());



    }
}
