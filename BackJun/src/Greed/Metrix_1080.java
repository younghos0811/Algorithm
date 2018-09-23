package Greed;

/**
 *
 *  url : https://www.acmicpc.net/problem/1080
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Metrix_1080 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] preArr = new int[row][col];
        int[][] nextArr = new int[row][col];

        for(int i = 0; i < row; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < col; j++) {
                preArr[i][j] = Character.getNumericValue(arr[j]);
            }
        }

        for(int i = 0; i < row; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < col; j++) {
                nextArr[i][j] = Character.getNumericValue(arr[j]);
            }
        }
        int cnt = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(preArr[i][j] != nextArr[i][j]) {
                    if((i > row-3) || (j > col-3)) {
                        //no same
                       cnt = -1;
                       i = row;
                       break;
                       //break 같은 개념
                    }
                    else {
                        chageArr(i,j,preArr);
                        cnt++;
                        //change value
                    }
                }
            }
        }
        System.out.println(cnt);

    }

    private static void chageArr(int startX, int startY, int[][] preArr) {
        for(int i = startX; i < startX+3; i++) {
            for(int j = startY; j < startY+3; j++) {
                preArr[i][j] =  preArr[i][j]^1;
            }
        }
    }
}
