package Demo.Demo4;

import java.util.Arrays;
import java.util.Scanner;

//http://nukestorm.tistory.com/51 format site


public class LastYear4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int m = sc.nextInt();
//        String[] timeTable = {"08:00", "08:01", "08:02", "08:03"};  // 115
//        String[] timeTable = {"09:10", "09:09", "08:00"}; //2 10 2
//        String[] timeTable = {"23:59"}; //111
        String[] timeTable =
                {"23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59"};
        int[] busDepartArr = new int[n];
        for(int i = 0; i < n; i++)
            busDepartArr[i] = i*t + 540;

        int[] remainManArr = new int[timeTable.length];
        for(int i = 0; i < timeTable.length; i++) {
            String[] times = timeTable[i].split(":");
            remainManArr[i] = Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
        }

        Arrays.sort(remainManArr);
        int k = 0;
        for(int i = 0; i < busDepartArr.length-1; i++) {
            for(int j = 0; j < m; j++) {

                if(k == remainManArr.length)
                    break;

                if(remainManArr[k] > busDepartArr[i])
                    break;
                k++;
            }
        }

        //last time
        int lastBustTime = busDepartArr[n-1];

        for(int i = 0; i < m-1; i++) {

            if(k == remainManArr.length)
                break;

            if(lastBustTime < remainManArr[k])
                break;
            k++;
        }

        if(k == remainManArr.length) {
            System.out.println(changeTime(lastBustTime));
        }
        else {
            if(remainManArr[k] > lastBustTime){
                System.out.println(changeTime(lastBustTime));
            }
            else
                System.out.println(changeTime(remainManArr[k]-1));
        }
    }

    private static String changeTime(int num) {
        String hour = String.format("%02d" , num/60);
        String min = String.format("%02d" , num%60);

        return hour + ":" + min;

    }
}
