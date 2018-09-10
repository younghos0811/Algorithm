package Greed;

/**
 *
 * URL : https://www.acmicpc.net/problem/10610
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Thirthy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int[] intArr = new int[arr.length];
        boolean isThirth = false;

        for(int i = 0; i < arr.length; i++) {
            intArr[i] = arr[i] - '0';
        }

        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += intArr[i];

            if(intArr[i] == 0)
                isThirth = true;
        }

        if(sum%3 != 0 | !isThirth) {
            System.out.println(-1);
        }
        else {
            Arrays.sort(intArr);

            StringBuilder sb = new StringBuilder();
            for(int i = arr.length-1; i >= 0; i--) {
                sb.append(intArr[i]);
            }
            System.out.println(sb.toString());
        }





    }
}
