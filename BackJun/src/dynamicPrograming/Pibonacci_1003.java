package dynamicPrograming;


/**
 *
 *
 * URL : https://www.acmicpc.net/problem/1003
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pibonacci_1003 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int maxN = 0;
        int[][] dp;
        int[] arr = new int[T];

        int k = 0;
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr[k] = n;
            if(n > maxN)
                maxN = n;
            k++;
        }

        dp = new int[maxN+1][2];
        dp[0][0] = 1;
        dp[1][1] = 1;

        for(int i = 2; i <= maxN; i++) {
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }

        for(int n : arr) {
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
