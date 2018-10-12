package math;

/**
 *
 *
 *
 * Url : https://www.acmicpc.net/problem/1850
 *
 *
 */

import java.util.Scanner;

public class GCD_1850 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = (int)gcd(sc.nextLong() , sc.nextLong());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cnt; i++) {
            sb.append("1");
        }

        System.out.println(sb.toString());

    }

    private static long gcd(long x , long y) {
        if(y == 0)
            return x;
        return gcd(y , x%y);
    }
}
