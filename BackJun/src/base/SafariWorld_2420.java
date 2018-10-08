package base;


import java.util.Scanner;

/**
 *
 * URL : https://www.acmicpc.net/problem/2420
 *
 */

public class SafariWorld_2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getAbsNum(sc.nextLong() - sc.nextLong()));
    }

    private static long getAbsNum(long longnum) {
        if(longnum < 0 )
            return longnum * -1;
        return longnum;
    }
}
