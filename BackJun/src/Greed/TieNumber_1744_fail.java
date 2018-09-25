package Greed;

/**
 *
 * url : https://www.acmicpc.net/problem/1744
 *
 *  why runtime error ?
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TieNumber_1744_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 1) {
                sum ++;
            }
            else {
                list.add(num);
            }
        }

        Collections.sort(list);

        while(list.get(0) <= 0) {
            int num = list.remove(0);

            if(!list.isEmpty() &&list.get(0) <= 0) {
                num *= list.remove(0);
                sum += num;
            }
            else {
                sum += num;
                break;
            }
        }

        if(list.isEmpty()) {
            System.out.println(sum);
        }
        else {
            Collections.sort(list, Collections.reverseOrder());

            for(int i = 0; i < list.size(); i++) {
                int num = list.get(i);
                if(i < list.size()-1) {
                    sum += (num * list.get(i+1));
                    i++;
                }
                else
                    sum += num;
            }
            System.out.println(sum);
        }


    }
}
