package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GobSem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();

        System.out.println(cal(a,b,c)+"");

    }

    private static long cal(long a ,long b ,long c) {

        if(b == 0)
            return 1;

        if(b == 1)
            return a%c;

        if(b%2 == 0) {
            long temp = cal(a,(b)/2,c);
            return (temp*temp)%c;
        }
        else {

            long temp = cal(a,(b-1),c);
            return (a * temp) % c;
        }
    }
}
