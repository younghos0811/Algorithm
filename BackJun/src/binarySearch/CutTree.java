package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutTree {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeCnt = Integer.parseInt(st.nextToken());
        long needsSize = Integer.parseInt(st.nextToken());
        int[] arr = new int[treeCnt];
        long left = 1;
        long right = 0;
        long solution = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < treeCnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(right < arr[i])
                right = arr[i];
        }
        right--;

        while(left <= right) {
            long mid = (left+right)/2;
            long sum = 0;

            for(int i = 0; i < treeCnt; i++) {
                sum += Math.max(0,arr[i]-mid);
            }

            if(sum >= needsSize) {
                solution = mid;
                left = mid +1;
            }
            else {
                right = mid-1;
            }
        }

        System.out.println(solution);

    }
}
