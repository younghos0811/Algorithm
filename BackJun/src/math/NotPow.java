package math;

/**
 *
 * 문제 URL : httpㅁ (i)s://www.acmicpc.net/problem/1016
 *
 * My Think :
 *
 * - long 과 int에 주의하자 int i ,  long a = i * i ; 일 경우에 이상한 값이 들어갈수있음!! i*i가 계산된 이후에 long타입이 되므로
 *   i*i의 결과가 int값을 넘으면 이상한 값이 들어감
 *
 * - 에라토스테네스의 채 이용 !! 2~n의 제곱의 값들을 지워나가면서 처리!!!!
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NotPow {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] arr = new boolean[(int)(max-min+1)];

        for(long i = 2; i*i <= max; i++) {
            long powNum = i*i;
            long startNum = min + (powNum -(min%powNum))%powNum;

            for(long j = startNum; j <= max; j += powNum) {
                arr[(int)(j - min)] = true;
            }
        }

        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i])
                cnt++;
        }

        System.out.println(cnt);



    }
}
