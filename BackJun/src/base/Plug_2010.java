package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * URL : https://www.acmicpc.net/problem/2010
 *
 */
public class Plug_2010 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int CNT = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < CNT; i++) {
            int multi_cnt = Integer.parseInt(br.readLine());
            result += multi_cnt -1;
        }

        // last plug + 1
        result++;

        System.out.println(result);

    }
}
