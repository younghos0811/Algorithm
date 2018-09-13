package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vCnt = Integer.parseInt(br.readLine());
        int cmdCnt = Integer.parseInt(br.readLine());
        int[][] arr = new int[vCnt+1][vCnt+1];

        for(int[] rowArr : arr) {
            Arrays.fill(rowArr , Integer.MAX_VALUE);
        }

        for(int i = 1; i <= vCnt; i++ )
            arr[i][i] = 0;

        StringTokenizer st;
        for(int i = 0; i < cmdCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            if(arr[start][end] > val)
                arr[start][end] = val;
        }

        for(int k = 1; k <= vCnt; k++) {
            for(int i = 1; i <= vCnt; i++) {
                if(arr[i][k] == Integer.MAX_VALUE)
                    continue;;
                for(int j = 1; j <= vCnt; j++) {
                    if(arr[k][j] == Integer.MAX_VALUE)
                        continue;;

                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= vCnt; i++) {
            for(int j = 1; j <= vCnt; j++) {
                if(arr[i][j] == Integer.MAX_VALUE)
                    sb.append("0 ");
                else
                    sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}
