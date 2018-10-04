package base;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/2920
 *
 */

public class EumGyae_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isAccending = true;
        boolean isDecceding = true;

        for(int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        for(int i = 1; i < 7; i++) {

            if(arr[i] + 1 != arr[i+1]) {
                isAccending = false;
            }

            if(arr[i] - 1 != arr[i+1]) {
                isDecceding = false;
            }
        }

        if(isAccending)
            System.out.println("ascending");
        else if (isDecceding)
            System.out.println("descending");
        else
            System.out.println("mixed");



    }
}
