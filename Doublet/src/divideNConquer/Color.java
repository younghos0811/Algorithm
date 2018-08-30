package divideNConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Color {

    static int[][] map;
    static int[] colorArr= new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getColor(0,0,n);
        System.out.println(colorArr[0]);
        System.out.println(colorArr[1]);


    }

    private static void getColor(int x , int y , int size) {
        int firstNum =map[x][y];
        boolean isSame = true;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(firstNum != map[x+i][y+j]) {
                    i = 1000000;/**/
                    isSame = false;
                    break;
                }
            }
        }

        if(isSame) {
            colorArr[firstNum]++;
        }else {
            size = size/2;
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    getColor(x+i*size,y+j*size,size);
                }
            }
        }

    }
}

