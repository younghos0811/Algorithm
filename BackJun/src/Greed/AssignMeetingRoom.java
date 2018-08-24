package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AssignMeetingRoom {

    static private class Meet implements Comparable<Meet> {
        int startTime = 0;
        int endTime = 0;

        public Meet(int start , int end) {
            startTime = start;
            endTime = end;
        }

        @Override
        public int compareTo(Meet o) {
           if(this.endTime == o.endTime)
               return this.startTime - o.startTime;
           return this.endTime - o.endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roomCnt = Integer.valueOf(br.readLine());
        Meet[] meets = new Meet[roomCnt];
        int resultCnt = 0;
        for(int i = 0; i < roomCnt; i++) {
            String[] times = br.readLine().split(" ");
            meets[i] = new Meet(Integer.valueOf(times[0]),Integer.valueOf(times[1]));
        }

        Arrays.sort(meets);

        int lastTime = -1;
        for(int i = 0; i < roomCnt; i++) {
            if(meets[i].startTime >= lastTime) {
                resultCnt++;
                lastTime = meets[i].endTime;
            }
        }

        System.out.println(resultCnt);
    }
}
