package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DongGeon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int cnt = Integer.valueOf(splits[0]);
        int goal = Integer.valueOf(splits[1]);;
        int[] Dongens = new int[cnt];
        int moneyCnt = 0;

        for(int i = cnt-1; i >= 0; i--) {
            Dongens[i] = Integer.valueOf(br.readLine());
        }

        int i = 0;
        while(goal > 0) {
            if(Dongens[i] <= goal) {
                moneyCnt += goal/Dongens[i];
                goal = goal%Dongens[i];
            }
            i++;
        }

        System.out.println(moneyCnt);

    }

}