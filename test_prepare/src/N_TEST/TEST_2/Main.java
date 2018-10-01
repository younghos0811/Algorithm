package N_TEST.TEST_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] pays = new int[cnt];

        for(int i = 0; i < cnt; i++) {
            pays[i] = sc.nextInt();
        }

        int start = 0;
        int profit = 0;
        while(start < cnt) {

            int max = 0;
            int maxIndex = 0;
            int coinCnt = 0;
            for(int i = start; i < cnt; i++) {
                if(max <= pays[i]) {
                    max = pays[i];
                    maxIndex = i;
                }
            }

            if(maxIndex == start) {
                start++;
            }
            else {
                for(int i = start; i < maxIndex; i++) {
                    if(pays[i] < max) {
                        coinCnt++;
                        profit -= pays[i];
                    }
                    start++;
                }

                profit += (coinCnt)*pays[maxIndex] - 1;
                coinCnt = 0;
                start++;
            }

        }

        System.out.println(profit);

        
    }
}
