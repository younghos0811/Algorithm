package greed_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int totTime = 0;
        int result = 0;
        int[] arr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < cnt; i++) {
            arr[i]  = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int time : arr) {
            result += (totTime + time);
            totTime += time;
        }

        System.out.println(result);



    }
}
