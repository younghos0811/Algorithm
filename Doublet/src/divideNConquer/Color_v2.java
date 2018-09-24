package divideNConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Color_v2 {

    private static int[] colorCntArr = new int[2];
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,N);
        System.out.println(colorCntArr[0]);
        System.out.println(colorCntArr[1]);

    }

    private static void divide(int startX, int startY, int size) {
        if(size == 1) {
            colorCntArr[map[startX][startY]]++;
            return;
        }

        boolean isSame = true;
        for(int i = startX; i < startX + size; i++) {
            for(int j = startY; j < startY + size; j++) {
                if(map[startX][startY] != map[i][j]) {
                    isSame = false;
                    i = startX + size;
                    break;
                }
            }
        }

        if(isSame) {
            colorCntArr[map[startX][startY]]++;
        }
        else {
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    divide(startX + (size/2)*i , startY + (size/2)*j , size/2);
                }
            }
        }

    }
}
