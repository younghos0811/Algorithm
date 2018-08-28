package base;

import java.util.Arrays;

public class SelfNumber {


    static boolean[] isNumbers = new boolean[100001];
    static boolean[] isUse = new boolean[100001];

    public static void main(String[] args) {
//        Arrays.fill(isNumbers,true);

        for(int i = 1; i < 10001; i++) {
            d(i);

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 10001; i++) {
            if(!isNumbers[i])
                sb.append(i+"\n");
        }

        System.out.println(sb.toString());

    }

    private static void d(int n) {
        if(isUse[n])
            return;

        isUse[n] = true;

        int tenCnt = getTenPosition(n);
        int sum = n;

        char[] arr = (n + "").toCharArray();
        for(int i = 0; i < arr.length; i++) {
            sum += Character.getNumericValue(arr[i]);
        }

        if(sum > 10000)
            return;

        isNumbers[sum] = true;
        d(sum);
    }

    private static int getTenPosition(int n) {
        int cnt = 1;

        while(true) {
            n = n/10;
            if(n == 0)
                return cnt;
            cnt++;
        }

    }
}
