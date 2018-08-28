package graph;

/**
 *
 * 문제 : 백준 - 줄세우기
 * URL : https://www.acmicpc.net/problem/2252
 * 문제 요약 :
 *  - 주어진 문제는 1~ N명을 키 순서대로 정렬 하는 것
 *  - 다만 입력값에서는 몇 명의 키의 비교값만을 줌
 *  - 이 비교값을 통해서 정렬 하는 것
 *
 * 분류 : 그래프
 * 풀이 Key : 위상정렬
 *
 * 풀이 Point
 * - 위상정렬을 사용
 * - 만약 1번이 3번보다 큰 1 3 이런것을 표현하기 위해서 2차원 배열을 사용시 메모리 초과 오류 발생 -> ArrayList를 사용하여 메모리 문제 해결
 * - 위상정렬은 요약하면 indegree가 0이면 que에 집어넣고 뺴냈을때는 접근되어있는 간선들을 하나씩 삭제해가면서 que에 집어 넣는 과정 반복
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SetLine {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int[] indeArr = new int[cnt+1];
        List<Integer>[] connListArr = new ArrayList[cnt+1];

        for(int i=1; i<cnt+1; i++)
            connListArr[i] = new ArrayList<>();

        for(int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            connListArr[first].add(second);
            indeArr[second]++;
        }

        Queue<Integer> que = new LinkedList<Integer>();

        for(int i = 1; i <= cnt; i++) {
            if(indeArr[i] == 0)
                que.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()) {
            int num = que.poll();
            sb.append(num + " ");

            for(int i = 0; i < connListArr[num].size(); i++) {
                int n = connListArr[num].get(i);
                indeArr[n]--;
                if(indeArr[n] == 0)
                    que.offer(n);
            }

        }

        System.out.println(sb.toString());


    }
}
