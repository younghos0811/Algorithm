package base;

/**
 *
 *
 * URL :https://www.acmicpc.net/problem/8958
 *
 */

import java.util.Scanner;

public class OXQuiz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        while(N-- > 0) {
            char[] arr = sc.nextLine().toCharArray();
            int sum  = 0;
            int thisNum = 0;
            for(char ch : arr) {
                if(ch == 'O')
                    thisNum++;
                else
                    thisNum = 0;
                sum += thisNum;
            }
            System.out.println(sum);
        }
    }
}
