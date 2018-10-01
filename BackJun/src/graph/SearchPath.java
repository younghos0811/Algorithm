package graph;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/11403
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchPath {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                if(map[i][k] == 0)
                    continue;
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 1)
                        continue;

                    if(map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        String result = "";
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                result += map[i][j] + " ";
            }
            result += "\n";
        }

        System.out.println(result);


    }
}
