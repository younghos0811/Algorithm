package dynamicPrograming;

/**
 * 문제 URL : https://www.acmicpc.net/problem/10942
 *
 * 문제 요약 :
 * - 주어진 숫자 배열에서 i ,j 가 팰린드롬이 되는지 확인항는 문제
 *
 * 풀이 요약 :
 * - 팰린드롬의 경우의 수는 3가지 이다.
 *   1. 길이가 1 인경우 : 무조건 팰린드롬이다.
 *   2. 길이가 2인 경우 : i == j이면 팰린드롬이다.
 *   3. 길이가 3인 경우 : i == j일 경우에  i+1,j-1이 팰린드롬인 경우에 팰린드롬이다.
 *   4. 팰린드롬을 구할 떄마다 배열에 저장하여 재활용 해야만 Time Out을 해결할 수 있다.
 *
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Palendrom {


    static int[] numArr;
    static int[][] palAfrr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        numArr = new int[cnt+1];
        palAfrr = new int[cnt+1][cnt+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= cnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int cmdCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= cmdCnt; i++) {
            st = new StringTokenizer(br.readLine());
            if(isPalindrom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) == 2){
                sb.append("1\n");
            }
            else {
                sb.append("0\n");
            }
        }

        System.out.println(sb.toString());

    }

    private static int isPalindrom(int start, int end ) {
        if (start == end)
            return 2;

            if (start + 1 == end) {
                if (numArr[start] == numArr[end])
                    return 2;
                return 1;
            }

            if(palAfrr[start][end] >= 1)
                return palAfrr[start][end];

            if (numArr[start] != numArr[end])
                return 1;
            else {
                return (palAfrr[start][end] = isPalindrom(start + 1, end - 1));
            }

    }

}
