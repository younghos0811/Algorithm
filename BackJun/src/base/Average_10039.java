package base;

import java.util.Scanner;

public class Average_10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        for(int i = 0; i < 5; i++) {
            int n = sc.nextInt();

            sum += n < 40 ? 40 : n;
        }


        System.out.println(sum/5);
    }
}
