package Demo.L_DEMO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String result = "";
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(K == M)
                result += combination(N, K) +"\n";
            else
                result += (combination(N, M) * combination(N, K-M)) +"\n";
        }
        System.out.println(result);
    }

    private static int factorial(int n) {
        if(n <= 1)
            return n;
        return factorial(n-1)*n;
    }

    private static int combination(int c, int n) {
        if(n == c)
            return 1;
        return factorial(c)/(factorial(c-n)*factorial(n));
    }
}
