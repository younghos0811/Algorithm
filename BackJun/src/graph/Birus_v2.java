package graph;

import java.util.Scanner;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/2606
 *
 */


public class Birus_v2 {

    private static int[] parent;

    private static int find(int x) {
        if(parent[x] == x)
            return x;
        return find(parent[x]);
    }

    private static void union(int x , int y) {
        x = find(x);
        y = find(y);

        if(x != y)
            parent[y] = x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = sc.nextInt();
        parent = new int[N+1];

        for(int i = 1; i <= N; i++)
            parent[i] = i;

        while(cnt-- > 0) {
            union(sc.nextInt() , sc.nextInt());
        }

        int result = 0;
        for(int i = 2; i <= N; i++) {
            if(find(1) == find(i))
                result++;
        }

        System.out.println(result);

    }
}
