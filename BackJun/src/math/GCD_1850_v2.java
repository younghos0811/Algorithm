package math;

/**
 *
 *
 *
 * Url : https://www.acmicpc.net/problem/1850
 *
 *
 */

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GCD_1850_v2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int G = (int)gcd(Long.parseLong(st.nextToken()) , Long.parseLong(st.nextToken()));
        String result = "1";

        while(G > 0) {
            if((G & 1) == 1) {
                bw.write(result);
            }

            G >>= 1;
            result = result.concat(result);
        }

        br.close();
        bw.close();
    }

    private static long gcd(long x , long y) {
        if(y == 0)
            return x;
        return gcd(y , x%y);
    }
}
