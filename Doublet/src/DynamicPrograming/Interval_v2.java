package DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Interval_v2 {

    private static int[][] dp;
    private static List<Integer> sizeList;
    private static int[] arr;
    private static int[][] cutIndexArr;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        dp = new int[N][N];
        sizeList = new ArrayList<>();
        cutIndexArr = new int[N][N];

//        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            Arrays.fill(dp[i] , -1);
        }

        divide(0,N-1);

        System.out.println(dp[0][N-1]);

        int cnt = 1;
        int preNum = 0;
        int next = cutIndexArr[0][N-1];

        if(next == N-1) {
            sizeList.add(N);
        }
        else
            sizeList.add(next - preNum +1);

        while(next < N-1) {
            preNum = next;
            next = cutIndexArr[next+1][N-1];
            sizeList.add(next - preNum );
            cnt++;
        }

        System.out.println(cnt);

        for(int i = 0; i < sizeList.size(); i++) {
            System.out.print(sizeList.get(i) + " ");
        }



    }

    private static void divide(int start ,int end) {

        int diffVal = maxDiff(start, end);
        if(end - start < 3) {
            dp[start][end] = diffVal;
            cutIndexArr[start][end] = end;
            return;
        }

        int max= diffVal;
        int maxCut = end;

        for(int i = start+1; i <end-1; i++) {
            int sum = 0;
            if(dp[start][i] == -1)
                divide(start,i);
            sum += dp[start][i];

            if(dp[i+1][end] == -1)
                divide(i+1,end);
            sum += dp[i+1][end];

            if(max < sum) {
                maxCut = i;
                max = sum;
            }
        }

        dp[start][end] = max;
        cutIndexArr[start][end] = maxCut;
//            cutList.add(maxCut);
        return;
    }

    private static int maxDiff(int start , int end) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = start; i <= end; i++) {
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }

        return max - min;
    }



}
