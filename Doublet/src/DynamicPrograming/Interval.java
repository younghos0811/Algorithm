package DynamicPrograming;

/**
 *
 *
 * 문제 요약 :
 *  주어진 수 배열이 주어졌을 때 최소 2개이상씩 숫자를 짝지어서 각 구간의 최대값 - 최소값이 구간의 합이 된다.
 *  이떄에 구간의 총 합이 가장 크게 될 수 있는 구간의 합 및 구간의 갯수 그리고 구간별 크기를 출력하는 문제
 *
 *  풀이 방법:
 *  - 구간의 크기가 2인 경우에는 두 수의 차가 구간의 합이 된다.
 *  - 구간의 크기가 3인 경우에는 최대값 - 최소값이 구간의 하이 된다.
 *  - 구간의 크기가 4인 경우에는 아래의 경우의 수 중 하나가 최대값이 된다
 *     1. 최댁밧 - 최소값
 *     2. divde되서 구간의 합
 *      ex) 1~7 의 구간의 합은
 *          1 ~7 의 최대값 - 최소값 vs 1~5 + 6~7 vs 1~4 + 5~7 vs 1~3 + 4~7 vs 1~2 +3~7
 *     중에 하나 이다.
 *  - 각 구간들을 dp로 저장하여 이미 구한 값은 그대로 사용한다.
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Interval {

    static int[] arr;
    static int[][] dp;
    static int[][] divide;
    static final int MAX = 500;
    static final int MIN = 0;
    static int divCnt = 0;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        arr = new int[cnt];
        dp = new int[cnt][cnt];
        divide = new int[cnt][cnt];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < cnt; i++) {
            for(int j = 0; j < cnt; j++)
                dp[i][j] = -1;
        }


        for(int i = 0; i < cnt; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(interval(0,cnt-1));
        print(0,cnt-1, sb);
        System.out.println(divCnt);
        System.out.println(sb.toString());



    }

    private static int interval(int start, int end) {
        if(dp[start][end] > -1) {
            return dp[start][end];
        }
        else if(end - start == 1) {
            divide[start][end] = start;
            dp[start][end] = Math.abs(arr[end] - arr[start]);
        }
        else if(end - start == 2) {
        divide[start][end] = start;
        dp[start][end] = maxNum(start,end);
    }
        else {
            int max = 0;
            int dividePoint = start;

            for(int i = start+1; i <= end-2; i++ ) {
                int thisMaxVal = interval(start,i) + interval(i+1,end);;
                if(thisMaxVal > max){
                    max = thisMaxVal;
                    dividePoint = i;
                }
            }

            int notDivideMaxVal = maxNum(start,end);
            if(max  < notDivideMaxVal) {
                dividePoint = start;
                max = notDivideMaxVal;
            }

            divide[start][end] = dividePoint;
            dp[start][end] = max;
        }

        return dp[start][end];

    }

    private static void print(int start , int end ,StringBuilder sb) {
        if(divide[start][end] == start) {
            divCnt ++;
            sb.append((end - start+1) + " ");
            return;

        }

        print(start, divide[start][end], sb);
        print(divide[start][end]+1, end, sb);

    }


    private static int maxNum(int start , int end) {
        int max = 0;
        int min = MAX;
        for(int i = start; i <= end; i++) {
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }
        return max - min;
    }


}
