package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * URL : https://www.acmicpc.net/problem/2606
 *
 */


public class Birus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cmdCnt = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N+1][N+1];
        StringTokenizer st;

        while (cmdCnt -- > 0) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            map[pre][next] = true;
            map[next][pre] = true;

        }

        for(int k = 1; k <= N; k++) {

            for(int i = 1; i <= N; i++) {
                if(!map[i][k])
                    continue;
                for(int j = 1; j <= N; j++) {

                    if(i == j || j == k)
                        continue;

                    if(map[i][k]&&map[k][j])
                        map[i][j] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = 2; i <= N; i++) {
            if(map[1][i] || map[i][1])
                cnt++;
        }

        System.out.println(cnt);



    }
}




