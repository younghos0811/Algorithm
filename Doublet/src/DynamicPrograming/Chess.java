package DynamicPrograming;

/**
 *
 * Key Point
 *
 * - 필요 배열은 [인원수][백팀선택][흰팀선택] 이렇게다
 * - 0부터 시작해서 각  흰색 , 검정, 선택안하는 것중 어떤값이 클지를 비교해서 큰값이 각 인원수 선택했을 떄의 최대값
 *
 *
 */

import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Chess {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int[][][] dp = new int[1001][16][16];
        int[] whiteArr = new int[1001];
        int[] blackArr = new int[1001];


        String s = null;
        int n = 1;
        while( sc.hasNext()) {
//            StringTokenizer st = new StringTokenizer(s);
//            whiteArr[n] = Integer.valueOf(st.nextToken());
//            blackArr[n] = Integer.valueOf(st.nextToken());
            whiteArr[n] = Integer.valueOf(sc.nextInt());
            blackArr[n] = Integer.valueOf(sc.nextInt());
            n++;
        }

        dp[1][1][0] = whiteArr[1];
        dp[1][0][1] = blackArr[1];

        for(int i = 1; i <= n-1; i++) {
            int maxWhiteCnt = i;
            if(i > 15)
                maxWhiteCnt = 15;

            for( int j = 0; j <= maxWhiteCnt; j++) {
                int maxBlackCnt = i - j;
                if(maxBlackCnt > 15)
                   maxBlackCnt = 15;

                for(int k = 0;  k <= maxBlackCnt; k++) {
                    int selectBlackVal = 0;
                    int selectWhiteVal = 0;
                    int noSelectVal = dp[i-1][j][k];

                    if(j > 0)
                        selectWhiteVal = dp[i-1][j-1][k] + whiteArr[i];
                    if(k > 0)
                        selectBlackVal = dp[i-1][j][k-1] + blackArr[i];

                    dp[i][j][k] = Math.max(Math.max(selectBlackVal,selectWhiteVal),noSelectVal);
                }
            }
        }

        System.out.println(dp[n-1][15][15]);



    }
}
