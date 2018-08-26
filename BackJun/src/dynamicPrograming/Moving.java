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
                /* 대각선 삭제 : 이유는 대각선으로 오는거는 왼쪽이나 오른쪽으로 오는 경우 아니면은 값이 클수가 없음 (단 만약 사탕갯수가 음수인 칸이 있다면은 의미가 있음)*/

                if(i > 0)
                    preLeft = maxValMap[i-1][j];
                if(j > 0)
                    preUp = maxValMap[i][j-1];
                maxValMap[i][j] = Math.max(preLeft,preUp) + map[i][j];
            }
        }

        System.out.println(maxValMap[row-1][col-1]);

    }
}
