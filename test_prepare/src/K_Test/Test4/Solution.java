package K_Test.Test4;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;

//        long min = Long.MAX_VALUE;
//        long len = food_times.length;
//        for(int num : food_times) {
//            if(min > num)
//                min = num;
//        }

        List<Integer> foodList = new ArrayList<>();

        for(int num : food_times) {
           foodList.add(num);
        }

        long len = food_times.length;
        while(k < len) {
            long min = Long.MAX_VALUE;
            for(int num : foodList) {
                if(num != 0 && min > num)
                    min = num;
            }

            long minuSize = 0;
            if(k < min*len) {
                while(k > len) {
                    k -= len;
                    minuSize++;
                }
            }
            else {
                k -= min * len;
                minuSize = min;
            }

            //k를 다 잘랐을떄
            for(int i = 0; i < foodList.size(); i++) {
                foodList.set(i,foodList.get(i) - (int)minuSize);
            }
            len--;
        }

        int nextIndex = -1;
        while(k != 0) {
            int preIndex = nextIndex;
            nextIndex = (nextIndex+1)%foodList.size();
            int num = foodList.get(nextIndex);

            if(num == 0) {
                foodList.set(nextIndex , num-1);
//                foodList.remo
                continue;
            }

//            if(foodList.get())

            k--;
        }

        for(int i = 0; i < food_times.length; i++) {
            nextIndex = (nextIndex+1)%(int)len;
            if(food_times[nextIndex] == 0)
                continue;
            return nextIndex+1;
        }

        return -1;
    }
}