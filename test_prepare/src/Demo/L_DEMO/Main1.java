package Demo.L_DEMO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());

        while(T-- > 0) {
            char[] arr = br.readLine().toCharArray();
            String result = "";
            int cnt = 0;

            for(int i = 0; i < arr.length; i++) {
                cnt++;
                if(i == arr.length -1 || arr[i] != arr[i+1]) {
                    result += (cnt + "" + arr[i]);
                    cnt = 0;
                }
            }

            System.out.println(result);
        }

    }
}

