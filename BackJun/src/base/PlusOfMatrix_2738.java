package base;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/2738
 *
 *
 */

import java.io.*;
import java.util.StringTokenizer;

public class PlusOfMatrix_2738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ROW = Integer.parseInt(st.nextToken());
        int COL = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[ROW][COL];
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < COL; j++) {
                matrixA[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < COL; j++) {
                result.append((matrixA[i][j] + Integer.parseInt(st.nextToken())) + " ");
            }
            result.append("\n");
        }

        bw.write(result.toString());

        br.close();
        bw.close();
    }
}
