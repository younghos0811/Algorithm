package dynamicPrograming;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * URL : https://www.acmicpc.net/problem/15988
 *
 */
public class OnePlusTwoThree {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String result = "";
        List<Integer> integerList = new ArrayList<>();
        long[] dp;
        int max = 0;

        while(T-- > 0) {
            int num = sc.nextInt();

            if(max < num)
                max = num;

            integerList.add(num);
        }

        dp = new long[max+1];
        dp[1] = 1;
        if(max >= 2)
            dp[2] = 2;
        if(max >= 3)
            dp[3] = 4;


        for(int i = 4; i <= max; i++) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1])%1000000009;
        }

        for(int num : integerList) {
            result += dp[num]%1000000009 + "\n";
        }

        System.out.println(result);
    }
}
