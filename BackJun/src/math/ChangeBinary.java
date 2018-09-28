package math;

/**
 *
 *
 * url : https://www.acmicpc.net/problem/11179
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder(Integer.toBinaryString(N));
        sb.reverse();
        System.out.println(Integer.parseInt(sb.toString(), 2));
    }
}
