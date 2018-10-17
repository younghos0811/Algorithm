package base;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/2745
 *
 *
 */

import java.util.Scanner;

public class ChnageJinBub_2745 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] N = sc.next().toCharArray();
        int B = sc.nextInt();
        int result = 0;
        for(int i = 0; i < N.length; i++) {
            int n = getChangeNum(N[i]);
            int b = (int)Math.pow(B,(N.length-1) - i);
            result += n * b;
        }

        System.out.println(result);
    }

    private static int getChangeNum(char n) {
        if(n < 58) {
            return Character.getNumericValue(n);
        }
        else {
            return n - 55;
        }
    }

}
