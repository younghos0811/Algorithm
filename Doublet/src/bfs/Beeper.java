package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beeper {

    private static class Vertex {
        int x = 0;
        int y = 0;
    }

    private static class Node implements Comparable<Node> {
        int lv = 0;
        List<Vertex> list = new ArrayList<>();
        boolean[] isVisits;
        int pathLength = 0;
        int lastVNum = 0;
        int vIndexSum = 0;

        @Override
        public int compareTo(Node o) {
            return this.pathLength - o.pathLength;
        }
    }

    static int shortestPath = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] map = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        Vertex start = new Vertex();
        st = new StringTokenizer(br.readLine());
        start.x = Integer.parseInt(st.nextToken());
        start.y = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(br.readLine());
        Vertex[] vArr = new Vertex[size+1];
        vArr[0] = start;
        int sum = 0;

        for(int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            vArr[i] = new Vertex();
            vArr[i].x = Integer.parseInt(st.nextToken());
            vArr[i].y = Integer.parseInt(st.nextToken());
            sum += i;
        }

        Queue<Node> que = new PriorityQueue<>();
        Node startNode = new Node();
        startNode.isVisits = new boolean[size+1];
        startNode.list.add(start);
        startNode.vIndexSum = sum;
        que.add(startNode);

        while(!que.isEmpty()) {
            Node thisNode = que.poll();

            for(int i = 1; i <= size; i++) {
                if(!thisNode.isVisits[i]) {
                    int path = thisNode.pathLength + getPath(vArr[thisNode.lastVNum],vArr[i]);

                    if(path >= shortestPath)
                        continue;;

                    if(thisNode.lv == size-1) {
                        int lastIndex = thisNode.vIndexSum - i;
                        path = path + getPath(vArr[i] , vArr[lastIndex]);
                        if(path < shortestPath)
                            shortestPath = path;
                        continue;
                    }

                    Node node = new Node();
                    node.lv = thisNode.lv +1;
                    node.isVisits = new boolean[size+1];
                    copyList(thisNode.list,node.list);
                    copyIsVisit(thisNode.isVisits,node.isVisits);
                    node.list.add(vArr[i]);
                    node.pathLength = path;
                    node.lastVNum = i;
                    node.isVisits[i] = true;
                    node.vIndexSum = thisNode.vIndexSum - i;
                    que.offer(node);
                }
            }

        }

        System.out.println("The shortest path has length " + shortestPath);

    }

    private static int getPath(Vertex src, Vertex dest) {
        return Math.abs(dest.x-src.x) + Math.abs(dest.y-src.y);
    }

    private static void copyList(List<Vertex> source , List<Vertex> dest) {
        for(int i = 0; i < source.size(); i++)
            dest.add(source.get(i));
    }

    private static void copyIsVisit(boolean[] src , boolean[] dest) {
        for(int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

}
