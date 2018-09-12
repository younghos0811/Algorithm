package DvideNQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountOfPaper {

    static int[] NUMS = new int[3];
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        arr = new int[len][len];
        StringTokenizer st;

        for(int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dive(0,0, len);

        for(int i = 0; i < 3; i++)
            System.out.println(NUMS[i]);

    }

    private static void dive(int startX, int startY, int len) {

        if(len == 1) {
            NUMS[arr[startX][startY]+1]++;
            return;
        }

        boolean isSame = true;

        for(int i = startX; i < startX+len; i++) {
            for(int j = startY; j < startY+len; j++) {
                if(arr[i][j] != arr[startX][startY]) {
                    isSame = false;
                    i = startX+len;
                    j = startY+len;
                }
            }
        }

        if(isSame) {
            NUMS[arr[startX][startY]+1]++;
        }
        else {
            int nextLen = len/3;

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    dive(startX+nextLen*i , startY+nextLen*j , nextLen);
                }
            }
        }
    }
}
