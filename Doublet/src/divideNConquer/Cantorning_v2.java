package divideNConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cantorning_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = (int)Math.pow(3,Integer.parseInt(br.readLine()));
        boolean[] isEmptryArr = new boolean[N];
        divide(0, N , isEmptryArr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(isEmptryArr[i])
                sb.append(" ");
            else
                sb.append("-");
        }

        System.out.println(sb.toString());
    }

    private static void divide(int start ,int size, boolean[] arr){
        if(size == 1)
            return;

        int newSize = size/3;
        int emptyStartIndex = start + newSize;
        int emptyEndIndex = start + newSize*2 -1;

        for(int i = emptyStartIndex; i <= emptyEndIndex; i++) {
            arr[i] = true;
        }

        divide(start, newSize , arr);
        divide(emptyEndIndex+1 , newSize, arr);
    }
}
