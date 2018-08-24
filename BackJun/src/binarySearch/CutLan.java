package binarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutLan {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeCnt = Integer.parseInt(st.nextToken());
        int needsCnt = Integer.parseInt(st.nextToken());
        Long[] treeArr = new Long[treeCnt];
        long maxCutSize = 0;
        long minCutSize = 1;

        for(int i = 0; i < treeCnt; i++) {
            treeArr[i] = Long.parseLong(br.readLine());
            if(maxCutSize < treeArr[i])
                maxCutSize = treeArr[i];
        }

        long solveSize = 0;
        while(minCutSize <= maxCutSize) {
            long cutSize = (minCutSize+maxCutSize)/2;
            int thisTreeCnt = 0;

            for(long treeSize : treeArr) {
                thisTreeCnt += (treeSize/cutSize);
            }

            if(thisTreeCnt >= needsCnt) {
                minCutSize = cutSize+1;
                solveSize = cutSize;
            }
            else {
                maxCutSize = cutSize-1;
            }
        }

        System.out.println(solveSize);
    }
}
