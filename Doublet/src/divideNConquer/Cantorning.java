package divideNConquer;

/*

n 을 입력으로 받아 아래와 같은 처리를 하는 프로그램을 작성하시오.

입력으로 받은 n 으로 3 n 개의 - 를 그린다.
중간의 3 n-1 개의 - 를 모두 지운다.
앞 , 뒤 부분의 - 를 - 가 하나 남을 때 까지 2 번 작업을 반복한다.
n 이 3 인 경우
123456789012345678901234567
---------------------------
---------         ---------
---   ---         ---   ---
- -   - -         - -   - -
입력
n ( 0 <= n <= 12 ) 이 입력으로 주어진다.
출력
- 사이에는 공백이다.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cantorning {

    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = (int)Math.pow(3,Integer.parseInt(br.readLine()));
        arr = new char[n];

        for(int i = 0; i < n; i++) {
            arr[i] = '-';
        }

        divide(0,n-1,n);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }

    private static void divide(int start, int end, int size) {
        if(start == end || size == 1)
            return;
        int nextSize = size/3;
        for(int i = start+nextSize; i <= (end-nextSize); i++ ) {
            arr[i] = ' ';
        }

        divide(start, start+nextSize-1, nextSize);
        divide(end-nextSize+1, end, nextSize);
    }
}
