package math;

/**
 *
 *
 * URL = https://www.acmicpc.net/problem/1057
 *
 */

import java.util.Scanner;

public class Tournament_1057 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int kim = sc.nextInt();
        int im = sc.nextInt();
        int groupCnt = 2;
        int round = 1;

        while(groupCnt/2 < N) {
            int groupIndex = (int)Math.ceil((double)kim/groupCnt);
            int groupStart = (groupIndex-1)*groupCnt + 1;
            int groupEnd = groupIndex*groupCnt;

            if(groupEnd > N)
                groupEnd = N;

            if(im >= groupStart && im <=groupEnd) {
                break;
            }

            round++;
            groupCnt *= 2;

        }

        System.out.println(round);
    }
}
