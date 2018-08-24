package Greed;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RopeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.valueOf(br.readLine());
        List<Integer> plustList = new ArrayList<Integer>();
        List<Integer> minusList = new ArrayList<Integer>();
        int thisNum = 0;
        int result = 0;

        for(int i = 0; i < cnt; i++) {
            thisNum = Integer.valueOf(br.readLine());
            if(thisNum <= 0)
                minusList.add(thisNum);
            else if(thisNum > 1)
                plustList.add(thisNum);
            else
                result++;
        }


        result += getCalculate(plustList, false);
        result += getCalculate(minusList, true);

        System.out.println(result);

    }

    private static int getCalculate(List<Integer> list, boolean isReverse) {
        int result = 0;

        if(list.size() > 1) {

            if(isReverse) {
                Collections.sort(list, Collections.reverseOrder());
            }
            else {
                Collections.sort(list);
            }

            for(int i = list.size()-1; i >= 0; i--) {
                if(i == 0) {
                    result += list.get(0);
                }
                else {
                    result += list.get(i)*list.get(i-1);
                    i--;
                }
            }
        }
        else if(list.size() == 1) {
            result += list.get(0);
        }

        return result;

    }
}
