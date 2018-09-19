package Demo.K_Demo.Demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LastYear_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] preArr = new int[n];
        int[] nextArr = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nextArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            nextArr[i] = nextArr[i]|preArr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int num = (int)Math.pow(2,n-1) >> j;

                if((nextArr[i] & num) == num)
                    sb.append("#");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}
