package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[][] dist = new int[cnt+1][cnt+1];

        for(int i = 1; i <= cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= cnt; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k <=cnt; k++) {
            for(int i = 1; i <= cnt; i++) {
                for(int j = 1; j <= cnt; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println(dist[start][end]);

    }
}
