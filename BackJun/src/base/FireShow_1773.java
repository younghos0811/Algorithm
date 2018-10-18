package base;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/1773
 *
 *
 */


import java.util.Scanner;

public class FireShow_1773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studnet_cnt = sc.nextInt();
        final int TOTAL_TIME = sc.nextInt();
      //  Map<Integer,Boolean> map = new HashMap<>();
        int[] arr = new int[studnet_cnt];
        int result = 0;

        int i = 0;
        while(studnet_cnt-- > 0) {
            int thisTime = sc.nextInt();
            arr[i] = thisTime;
            i++;
        }

        for(int j = 1; j <= TOTAL_TIME; j++) {
            if(isContain(arr , j)) {
                result++;
            }
        }

        System.out.println(result);

    }

    private static boolean isContain(int[] arr , int n) {
        for(int i = 0; i < arr.length; i++) {
            if(n % arr[i] == 0) {
                return true;
            }
        }

        return false;
    }
}
