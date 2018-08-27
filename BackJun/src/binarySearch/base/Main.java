package binarySearch.base;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int sum = 0;

        for(int i = 0; i < cnt; i++) {
            sum += sc.nextInt();
        }
        double avg = (double)sum/cnt;
        System.out.println(avg);
        System.out.println(String.format("%.2f",avg));

    }
}

