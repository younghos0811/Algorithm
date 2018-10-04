package dynamicPrograming;

/**
 *
 * URL : https://www.acmicpc.net/problem/2193
 *
 */

import java.util.Scanner;

public class TwoChinSu_2193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[N+1][2];

        dp[1][1] = 1;
        if(N > 1) {
            dp[2][0] = 1;
            dp[2][1] = 0;
        }

        for(int i = 3; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
