package DvideNQ;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/11123
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Shape {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < testCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            char[][] map = new char[row][col];

            for(int j = 0; j < row; j++ ) {
                map[j] = br.readLine().toCharArray();
            }
            sb.append(func(map , row , col) + "\n");
        }

        System.out.println(sb.toString());

    }

    private static int func(char[][] map , int rowSize, int colSize) {
        int cnt = 0;

        for(int i = 0; i < rowSize; i++) {
            for(int j = 0; j < colSize; j++) {
                cnt += getSumShape(map, i , j);
            }
        }

        return cnt;
    }

    private static int getSumShape(char[][] map, int row, int col) {

        if(map[row][col] == '.') {
            return 0;
        }

        map[row][col] = '.';

        if(row > 0)
            getSumShape(map , row -1, col);
        if(col > 0)
            getSumShape(map , row , col - 1);
        if(row <( map.length-1))
            getSumShape(map , row +1, col);
        if(col < (map[0].length) - 1)
            getSumShape(map , row , col +1);

        return 1;
    }
}
