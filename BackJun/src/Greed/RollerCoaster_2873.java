package Greed;

/**
 *
 *  url : https://www.acmicpc.net/problem/2873
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RollerCoaster_2873 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int map[][] = new int[row][col];
        int cutX = 0;
        int cutY = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(((i+j)%2 == 1) && (map[i][j] < min)) {
                    cutX = i;
                    cutY = j;
                    min = map[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(row % 2 == 1){
            //row 홀수
            for(int i = 0; i < row; i++) {
                addRowString(0, col,i%2,sb);
                if(i != row -1)
                    sb.append("D");
            }
        }
        else if (col % 2 == 1) {
            // col 홀수
            for(int i = 0; i < col; i++) {
                addCoLString(0, row, i%2,sb);
                if(i != col -1)
                    sb.append("R");
            }
        }
        else {
            //둘다 짝수
            int i = 0;
            int startX= 0;
            int startY = 0;
            while(startX+1 < cutX) {
                addRowString(startY , col, 0 , sb);
                sb.append("D");
                addRowString(startY,col,1,sb);
                startX = startX+2;
                sb.append("D");
            }

//            System.out.println("cutx : " + cutX + " cutY :" + cutY);
//            System.out.println("first : " + sb.toString());

            //row는 같은 row
            while(startY+1 < cutY) {
                addCoLString(0 , 2, 0 , sb);
                sb.append("R");
                addCoLString(0,2,1,sb);
                startY = startY+2;
                sb.append("R");
            }

//            System.out.println("second : " + sb.toString());

            if(startX == cutX) {
                sb.append("DR");
            }
            else {
                sb.append("RD");
            }



//            System.out.println("thrid: " + sb.toString());
            startY = cutY + ((cutY+1)%2)+ 1;
            if(startY != col) {
                sb.append("R");
                for(i = startY; i < col; i++) {
                    addCoLString(0, 2, (i+1)%2,sb);
                    if(i != col -1)
                        sb.append("R");
                }
            }

            startX = cutX + ((cutX+1)%2)+1;

            if(startX != row) {
                sb.append("D");
                for(i = startX; i < row; i++) {
                    addRowString(0, col,(i+1)%2,sb);
                    if(i != row -1)
                        sb.append("D");
                }
            }
        }

        System.out.println(sb.toString());
    }

    private static void addRowString(int startY, int col ,int rightNum,StringBuilder sb) {
        String[] RIGHTARR = {"R","L"};

        for(int i = startY; i < col-1; i++) {
            sb.append(RIGHTARR[rightNum]);
        }
        ;
    }

    private static void addCoLString(int startX, int row, int upNum ,StringBuilder sb) {
        String[] UPARR = {"D","U"};

        for(int i = startX; i < row-1; i++) {
            sb.append(UPARR[upNum]);
        }
    }
}


//4 4
//2 3 1 5
//2 4 5 3
//9 8 7 2
//11 4 2 5
//RDRURDDLLLDRRR

/*

6 4
3 4 2 1
2 5 4 3
1 3 2 3
4 5 6 2
7 5 6 3
2 4 1 4
DRURDRDLLLDRRRDLLLDRRR

4 4
10 9 8 7
6 6 7 8
2 3 1 4
3 4 2 1
RRRDLLLDDRURRD

8 8
2 4 1 5 6 7 8 9
2 4 1 5 6 7 8 9
2 4 1 5 6 7 8 9
2 4 1 5 6 7 8 9
2 4 1 5 6 7 8 9
2 4 1 5 6 7 8 9
2 4 1 5 6 7 8 9
2 4 1 5 6 7 8 9
DRURRDRURDRURDDLLLLLLLDRRRRRRRDLLLLLLLDRRRRRRRDLLLLLLLDRRRRRRR

6 4
2 1 2 2
2 2 2 2
2 2 2 2
2 2 2 2
2 2 2 2
2 2 2 2
DRRURDDLLLDRRRDLLLDRRR


*/
