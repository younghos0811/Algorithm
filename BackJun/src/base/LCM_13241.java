package base;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/13241
 *
 */

import java.util.Scanner;

public class LCM_13241 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(lcm(sc.nextLong(),sc.nextLong()));
    }

    private static long lcm(long x, long y) {
        long gcd = gcd(x,y);

        return (x*y)/gcd;
    }

    private static long gcd(long x, long y) {
        if(y == 0)
            return x;

        return gcd(y, x%y);
    }
}
