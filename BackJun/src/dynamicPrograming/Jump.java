package dynamicPrograming;


/**
 *
 * URL : https://www.acmicpc.net/problem/1890
 *
 * 문제 요약 :
 * - N X N 맵을 준다.
 * - 맵에는 각각 1~9사이의 숫자가 들어있다.
 * - 각 맵에 도착했을 때 오른쪽이나 아래쪽으로 맵에 들어있는 숫자만큼 이동할 수 있다.
 * - 이떄에 0,0에서 시작하여 가장 끝으로 갈 수 있는 경우의 수는 ?
 *
 * 풀이방법 : DP
 *
 * My Think :
 * - 시작점부터 끝에서 가는 경우의 수는 역으로 계산하는게 수월하다.
 * - 각 dp[i][j]을 끝부터 역으로 구한다. dp[i][j]는 i,j부터 시작하여서 끝까지 갈 수 있는 경우의 수다
 * - dp[N-1][N-1] = 1로 시작한다. 이미 도착한걸로 쳐야하기 떄문이다.
 *
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jump {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[N-1][N-1] = 1;
        for(int i = map.length-1; i >= 0; i--) {

            for(int j = map.length-1; j >= 0; j--) {
                if(map[i][j] == 0)
                    continue;

                long thisCnt = 0;
                int thisnum = map[i][j];

                /** go right **/
                if((i + thisnum < map.length)) {
                    thisCnt += dp[i + map[i][j]][j];
                }

                /** go left **/
                if((j + thisnum < map.length)) {
                    thisCnt += dp[i][j+map[i][j]];
                }

                dp[i][j] = thisCnt;

            }
        }

        System.out.println(dp[0][0]);

    }


}
