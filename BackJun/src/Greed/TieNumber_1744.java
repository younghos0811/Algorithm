package Greed;

/**
 *
 * url : https://www.acmicpc.net/problem/1744
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TieNumber_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> plusList = new ArrayList<>();
        List<Integer> minusList = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 1) {
                sum ++;
            }
            else if(num <= 0){
                minusList.add(num);
            }
            else {
                plusList.add(num);
            }
        }

        sum += getCalculate(minusList , true);
        sum += getCalculate(plusList , false);

        System.out.println(sum);

    }

    private static int getCalculate(List<Integer> list , boolean isMinus) {
        int sum = 0;

        if(isMinus) {
            Collections.sort(list);
        }
        else
            Collections.sort(list, Collections.reverseOrder());

        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i);

            if(i < list.size()-1) {
                num *= list.get(i+1);
                i++;
            }

            sum += num;
        }

        return sum;
    }
}
