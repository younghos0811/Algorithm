package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dikstra {

    private static class Vertex{
        int num = 0;
        int distance = Integer.MAX_VALUE;
        List<Integer> path;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vCnt = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int startNum = Integer.parseInt(st.nextToken());
        int[] distanct = new int[vCnt+1];
        boolean[] isVisit = new boolean[vCnt+1];
        int[][] map = new int[vCnt+1][vCnt+1];
        int[] vPaths = new int[vCnt+1];

        Arrays.fill(vPaths, startNum);
        Arrays.fill(distanct,Integer.MAX_VALUE);

        int start = 0;
        int end = 0;
        int val = 0;
        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            val = Integer.parseInt(st.nextToken());
            map[start][end] = val;

            if(start == startNum) {
                distanct[end] = map[start][end];
            }
        }
        isVisit[startNum] = true;

        for(int i = 0; i < vCnt; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;

            for(int j = 1; j <= vCnt; j++) {
                if(!isVisit[j] && distanct[j] > 0 && min > distanct[j]) {
                    min = distanct[j];
                    minIndex = j;
                }
            }

            isVisit[minIndex] = true;

            for(int j = 1; j <= vCnt; j++) {
                if(!isVisit[j] && map[minIndex][j] != 0 && distanct[j] > (distanct[minIndex] + map[minIndex][j])) {
                    distanct[j] = distanct[minIndex] + map[minIndex][j];
                    vPaths[j] = minIndex;
                }
            }
        }

        StringBuilder resultSb = new StringBuilder();
        for(int i = 1; i <= vCnt; i++) {

            if(i == startNum) {
                resultSb.append(startNum + "\n");
                continue;
            }

            int parentNum = i;
            StringBuilder tempSb = new StringBuilder();
            do {
                tempSb.insert(0,parentNum + " ");
                parentNum = vPaths[parentNum];
            }
            while(startNum != parentNum);

            tempSb.insert(0, parentNum + " ");
            resultSb.append(tempSb.toString()+"\n");
        }

        System.out.println(resultSb.toString());
    }

}
