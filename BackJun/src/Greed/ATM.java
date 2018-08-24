package Greed;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.valueOf(br.readLine());
        int[] arr = new int[cnt];
        int result = 0;
        int arrTotal = 0;
        int i = 0;
        String[] timeStrs = br.readLine().split(" ");

        for(String timeStr : timeStrs) {
            arr[i] = Integer.valueOf(timeStr);
            i++;
        }

        Arrays.sort(arr);

        for(int time : arr) {
            result += (arrTotal+time);
            arrTotal += time;
        }

        System.out.println(result);


    }
}
