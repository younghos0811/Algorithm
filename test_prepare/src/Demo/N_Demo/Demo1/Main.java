package Demo.N_Demo.Demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_VAL = 3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[st.countTokens()];

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        solution(arr);
    }


    public static void solution(int[] arr) {
        List<Integer> list = new ArrayList<>(3);
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(list.contains(arr[i])) {
                list.remove(Integer.valueOf(arr[i]));
            }
            else if(list.size() == MAX_VAL) {
                sb.append(list.remove(0) + "\n");
                cnt++;
            }
            list.add(arr[i]);
        }

        if(cnt == 0)
            System.out.println(0);
        else {
            System.out.println(sb.toString());
        }
    }
}


