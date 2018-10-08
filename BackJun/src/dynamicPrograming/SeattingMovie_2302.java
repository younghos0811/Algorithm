package dynamicPrograming;

/**
 *
 * URL : https://www.acmicpc.net/problem/2302;
 *
 */

import java.util.Scanner;

public class SeattingMovie_2302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        int lenCnt = sc.nextInt();
        int[] lenArr = new int[lenCnt + 1];
        int[] dp = new int[N+1];
        int startIndex= 1;
        int max = 0;
        int result = 1;

        for(int i = 0; i < lenCnt; i++) {
            int num = sc.nextInt();
            if(num == startIndex) {
                lenArr[i] = 1;
                startIndex++;
            }
            else {
                lenArr[i] = num - startIndex;
                startIndex = num + 1;

                if(lenArr[i] > max)
                    max = lenArr[i];
            }
        }

        lenArr[lenCnt] = N > startIndex - 1 ? N - (startIndex - 1) : 1;

        if(max < lenArr[lenCnt])
            max = lenArr[lenCnt];

        dp[1] = 1;
        if(max > 1) {
            dp[2] = 2;
        }

        for(int i = 3; i <= max; i++) {
            dp[i] = dp[i-1] + dp[i-2];;
        }

        for(int len : lenArr) {
            result *= dp[len];
        }

        System.out.println(result);

    }

}
