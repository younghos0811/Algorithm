package Greedy;

/**
 *
 * 문제 : doublet germination
 *
 * My Think :
 *  - 주어진 꽃의 수가 5개로 한정되어 있음
 *  - dfd를 이용하여 모든케이스를 다 돌려봐도 가능한 경우의수
 *  - 중간에 2번이상이 될경우 시스템 종료를 시킨후 Ambigous를 출력
 *
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Germination {

    static String[] flowerNames = {"Poppy","Carnation","Sunflower","Daisy","Pansy",};
    static int[] startDays = new int[5];
    static int[] endDays = new int[5];
    static int[] genDays = new int[5];
    static boolean[] isGen = new boolean[5];
    static int[] thisGenFlowerNum = new int[5];
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 5; i++) {
            startDays[i] = Integer.parseInt(st.nextToken());
            endDays[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++) {
            genDays[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 5; i++) {
            isPromise(0,i);
        }

        System.out.println(sb.toString());

    }

    private static boolean isPromise(int genDayIndex , int flowerNum) {

        if(startDays[flowerNum] <= genDays[genDayIndex] && endDays[flowerNum] >= genDays[genDayIndex]) {
            //gen ok
            isGen[flowerNum] = true;
            thisGenFlowerNum[genDayIndex] = flowerNum;
            if(genDayIndex == 4) {
                //gen end
                cnt ++;
                if(cnt > 1) {
                    System.out.println("Ambiguous");
                    System.exit(0);
                }

                for(int i = 0; i <5; i++)
                    sb.append(flowerNames[thisGenFlowerNum[i]] + " ");
            }
            else {
                for(int i = 0; i < 5; i++) {
                    if(!isGen[i]) {
                        isPromise(genDayIndex+1, i);
                    }
                }
            }

        }

        isGen[flowerNum] = false;
        thisGenFlowerNum[genDayIndex] = -1;
        return false;


    }
}
