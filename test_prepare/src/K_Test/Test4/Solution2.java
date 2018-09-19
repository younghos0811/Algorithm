package K_Test.Test4;


class Solution2 {
    public int solution(int[] food_times, long k) {
        int answer = 0;

        long min = Long.MAX_VALUE;
        long len = food_times.length;
        for(int num : food_times) {
            if(min > num)
                min = num;
        }

        long minuSize = 0;
        int nextIndex = -1;
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
        for(int i = 0; i < food_times.length; i++) {
            food_times[i] = (int)food_times[i] - (int)minuSize;
        }

        while(k != 0) {
            nextIndex = (nextIndex+1)%(int)len;
            if(food_times[nextIndex] == 0)
                continue;
            food_times[nextIndex] --;
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