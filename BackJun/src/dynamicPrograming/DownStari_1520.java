package dynamicPrograming;

/**
 *
 * URL : https://www.acmicpc.net/problem/1520
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DownStari_1520 {

    static int[][] dp;
    static int[][] arr;
    static final int[] dx = {-1,1,0,0};  // 상 하 좌 우
    static final int[] dy= {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ROW = Integer.parseInt(st.nextToken());
        int COL = Integer.parseInt(st.nextToken());
        arr = new int[ROW][COL];
        dp = new int[ROW][COL];

        for(int i = 0; i < ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < COL; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < ROW; i++) {
            Arrays.fill(dp[i] , -1);
        }
        dp[0][0] = 1;
        System.out.println(go(ROW-1 , COL-1));
    }

    private static int go(int x, int y ) {
        if(dp[x][y] != -1)
            return dp[x][y];

        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(newX >= 0 && newY >= 0 && newX < dp.length && newY < dp[0].length) {
                if(arr[x][y] < arr[newX][newY])
                    cnt += go(newX , newY);
            }
        }

        dp[x][y] = cnt;

        return dp[x][y];
    }
}
