package fullSearch;


/**
 *
 * 문제 URL : https://www.acmicpc.net/problem/2003
 *
 * 문제 요약 : 주어진 수 배열에서 i~j까지의 합이 N인 경우의 수를 구하는 문제
 *
 * 풀이 방법:
 * 1. 완전 탐색으로는 Time over가 난다.
 * 2. 이에 완전 탐색을 하데 찾으려는 값이 초과하는 경우에는 그 다음의 경우의 수는 계산하지 않는다. (이 후의 케이스는 의미가 없으므로)
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumNumbers2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int goalVal = Integer.parseInt(st.nextToken());
        int[] arr = new int[cnt];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cnt; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < cnt; i++) {
            if(arr[i] >= goalVal) {
                if(arr[i] == goalVal)
                    result++;
                continue;
            }

            int sum = arr[i];
            for(int j = i+1; j < cnt; j++) {
                sum += arr[j];
                if(sum >= goalVal) {
                    if(sum == goalVal)
                        result++;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}
