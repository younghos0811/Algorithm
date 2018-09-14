package graph;

/**
 *
 *
 * 크루스칼 알고리즘 풀이
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Agrinet_vCrooscal {

    static int[] parent;

    static private class Edge implements Comparable<Edge>{
        int start = 0;
        int end = 0;
        int val = 0;

        @Override
        public int compareTo(Edge o) {
            if(this.val == o.val)
                return 0;
            else if(this.val > o.val)
                return 1;
            else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        parent = new int[cnt+1];
        List<Edge> edgeList = new ArrayList<>();
        int sum = 0;

        for(int i = 1; i <= cnt; i++) {
            parent[i] = i;
            for(int j = 1; j <= cnt; j++) {
                int start = i;
                int end = j;
                int val = sc.nextInt();

                if(val == 0)
                    continue;

                Edge edge = new Edge();
                edge.start = start;
                edge.end = end;
                edge.val = val;
                edgeList.add(edge);
            }
        }

        Collections.sort(edgeList);

        for(int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if(!isSameGroup(edge.start , edge.end)) {
                sum += edge.val;
                union(edge.start , edge.end);
            }
        }

        System.out.println(sum);

    }

    private static boolean isSameGroup(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y)
            return true;
        return false;
    }

    private static int find(int x){
        if(parent[x] == x)
            return x;
        return find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y)
        parent[y] = x;
    }

}
