package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/2711
 *
 *
 */

public class Otamen_2711 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String result  = "";

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            result += new StringBuilder(st.nextToken()).delete(index -1, index).toString() + "\n";
        }

        System.out.println(result);

    }
}
