package DataStructure;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/1717
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PresentSet_1717 {

    private static int[] parent;

    private static int find(int x) {
        if(parent[x] == x)
            return x;
        return find(parent[x]);
    }

    private static void union(int x , int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] =x;
        }
    }

    private static String isSameSet(int x ,int y) {
        x = find(x);
        y = find(y);

        if(x == y)
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for(int i = 1; i <= N; i++)
            parent[i] = i;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(cmd == 0) {
                union(x, y);
            }
            else {
                sb.append(isSameSet(x,y) + "\n");
            }
        }

        System.out.println(sb.toString());

    }
}
