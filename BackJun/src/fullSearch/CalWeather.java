package fullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CalWeather {

    static final int E = 15;
    static final int S = 28;
    static final int M = 19;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1;;i++) {
            if( (i-e)%E == 0 && (i-s)%S == 0 && (i-m)%M == 0) {
                System.out.println(i);
                break;
            }
        }

    }
}
