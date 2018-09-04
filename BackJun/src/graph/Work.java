package graph;

/**
 * 문제 URL : https://www.acmicpc.net/problem/2056
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Work {

    private static class WorkNode implements Comparable<WorkNode> {
        int id = 0;
        int remainWorkTime = 0;
        int dpCnt = 0;
        List<Integer> dpList = new ArrayList<>();

        @Override
        public int compareTo(WorkNode o) {
            return this.remainWorkTime - o.remainWorkTime;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cmdCnt = Integer.parseInt(br.readLine());
        WorkNode[] arr = new WorkNode[cmdCnt + 1];
//        Queue<WorkNode> workingNodeQue = new PriorityQueue<>();
        List<Integer> workingNodeQue = new ArrayList<>();
        int minWorkTime = Integer.MAX_VALUE;

        for(int i = 1; i <= cmdCnt; i++)
            arr[i] = new WorkNode();
        /** definition working node **/
        for(int i = 1; i <= cmdCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i].id = i;
            arr[i].remainWorkTime = Integer.parseInt(st.nextToken());
            int depNum = Integer.parseInt(st.nextToken());

            if(depNum == 0) {
                if(arr[i].remainWorkTime < minWorkTime)
                    minWorkTime = arr[i].remainWorkTime;
                    workingNodeQue.add(arr[i].id);
            }
            else {
                for(int j = 0; j < depNum; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i].dpCnt++;
                    arr[num].dpList.add(i);
                }

            }
        }

        /** working ... **/
        int result = 0;
        while(workingNodeQue.size() > 0) {
            int thisWorkSize = workingNodeQue.size();
            int k = 0;
            int thisWorkNum = minWorkTime;
            minWorkTime = Integer.MAX_VALUE;
            result += thisWorkNum;

            for(int i = 0; i < thisWorkSize; i++ ) {
                WorkNode node = arr[workingNodeQue.get(k)];
                node.remainWorkTime -= thisWorkNum;

                if(node.remainWorkTime == 0) {
                    // 작업 완료
                    for (int j = 0; j < node.dpList.size(); j++) {
                        int index = node.dpList.get(j);
                        arr[index].dpCnt--;
                        if (arr[index].dpCnt == 0) {
                            if (arr[index].remainWorkTime < minWorkTime) {
                                minWorkTime = arr[index].remainWorkTime;
                            }
                            workingNodeQue.add(index);
                        }
                    }
                    workingNodeQue.remove(k);
                }
                else {
                    if(node.remainWorkTime < minWorkTime)
                        minWorkTime = node.remainWorkTime;
                    k++;
                }
            }
        }

        System.out.println(result);

    }
}
