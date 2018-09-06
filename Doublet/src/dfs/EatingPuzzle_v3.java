package dfs;

/**
 * source 개선
 *
 * performance는 오히려 느려짐
 *
 * 여기서 중요한 포인트는 func함수의 파라미터가 이미 값이 들어가있는애로 들어가는 것이므로 그것만 처리하면된다.
 *
 * 값의 o,x 여부를 for문 i에 0,1을 곱해서 처리한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EatingPuzzle_v3 {

    static int maxCal = 0;
    static int[] arr;
    static int currentMaxCal = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxCal = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        arr = new int[cnt];
        st = new StringTokenizer(br.readLine());

        int remainCal = 0 ;
        for(int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            remainCal += arr[i];
        }

        for(int i = 0; i < 2; i++) {
            func(0,remainCal - arr[i]*i,arr[0]*i);
        }
        func(0,remainCal,0);
        System.out.println(currentMaxCal);
    }

    private static void func(int index, int remainCal, int thisCal) {

            if(index == arr.length-1) {
                if(thisCal > currentMaxCal)
                    currentMaxCal = thisCal;
                return;
            }

            for(int i = 0; i < 2; i++) {
                int nextRemain = remainCal-arr[index+1]*i;
                int nextCal = thisCal +arr[index+1]*i;
                if(isPromise(nextCal , nextRemain))
                 func(index+1,nextRemain,nextCal);
            }
    }

    private static boolean isPromise(int sumCal, int remainCal) {
        if(sumCal > maxCal)
            return false;
        if(sumCal == maxCal) {
            System.out.println(maxCal);
            System.exit(0);
        }
        if(sumCal + remainCal <= currentMaxCal)
            return false;

        return true;
    }
}
