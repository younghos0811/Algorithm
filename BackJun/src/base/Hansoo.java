package base;

import java.util.Scanner;

public class Hansoo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int hanCnt = 0;

        if(n < 100)
            hanCnt = n;
        else {
            hanCnt += 99;

            for(int i = 111; i <= n; i++) {
                int num = i;
                int first = num/100;
                num %= 100;
                int second = num/10;
                num %= 10;
                int last = num;
                if((second - first) == (last - second))
                    hanCnt++;
            }
        }

        System.out.println(hanCnt);

    }
}
