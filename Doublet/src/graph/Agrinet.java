package graph;

/**
 *
 *
 * 프림알고리즘 풀이 (향후 크루스칼로도 풀이 해보자)
 *
 */

import java.io.IOException;
import java.util.Scanner;

public class Agrinet {


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[][] distance = new int[cnt][cnt];
        boolean[] checkArr = new boolean[cnt];

        for(int i = 0; i < cnt; i++) {
            for(int j = 0; j < cnt; j++) {
                distance[i][j] = sc.nextInt();
            }
        }

        int k = 1;
        int len = 0;
        checkArr[0] = true;
        while(true) {

            if(k == cnt)
                break;

            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i = 0; i < cnt; i++) {
                if(!checkArr[i])
                    continue;

                for(int j = 1; j < cnt; j++) {
                    if(i ==j || checkArr[j])
                        continue;
                    if(min > distance[i][j]) {
                        minIndex = j;
                        min = distance[i][j];
                    }
                }
            }

            checkArr[minIndex] = true;
            len += min;
            k++;
        }

        System.out.println(len);

    }

}
