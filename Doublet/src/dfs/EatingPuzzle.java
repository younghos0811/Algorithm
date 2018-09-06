package dfs;

/**
 *
 * use BacktRACKING
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EatingPuzzle {

    static int maxCal = 0;
    static int[] arr;
    static int currentMaxCal = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxCal = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        arr = new int[cnt];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0,maxCal,0);
        System.out.println(currentMaxCal);
    }

    private static void func(int index, int remainCal, int thisCal) {
       int sumCal = thisCal + arr[index];
       boolean isEat = isPromise(sumCal);

        if(index == arr.length-1) {
            int currentCal = isEat?sumCal : thisCal;
            if(currentMaxCal < currentCal)
                currentMaxCal= currentCal;
            return;
        }


       if(isEat) {
           func(index+1, remainCal-arr[index],sumCal);
       }

       func(index+1,remainCal,thisCal);


    }

    private static boolean isPromise(int sumCal) {
       if(sumCal > maxCal)
           return false;
       if(sumCal < maxCal)
           return true;
       if(sumCal == maxCal) {
           //end system
           System.out.println(maxCal);
           System.exit(0);
       }
       return false;
    }
}
