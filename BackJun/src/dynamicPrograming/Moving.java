package dynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Moving {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][col];
        int[][] maxValMap = new int[row][col];

        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxValMap[0][0] = map[0][0];
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int preLeft = 0;
                int preUp = 0;
                int preCross = 0;

                if(i > 0)
                    preLeft = maxValMap[i-1][j];
                if(j > 0)
                    preUp = maxValMap[i][j-1];
                if(i > 0 && j > 0)
                    preCross = maxValMap[i-1][j-1];
                maxValMap[i][j] = Math.max(Math.max(preLeft,preUp), preCross) + map[i][j];
            }
        }

        System.out.println(maxValMap[row-1][col-1]);

    }
}
