package binarySearch.base;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        double sum = 0;
        double[] arr = new double[cnt];
        double max = 0;

        for(int i = 0; i < cnt; i++) {
            arr[i] = sc.nextInt();

            if(arr[i] > max)
                max = arr[i];
        }

        for(int i = 0; i < cnt; i++) {
            sum += (arr[i]/max)*100;
        }



        double avg = sum/cnt;
        System.out.println(String.format("%.2f",avg));

    }
}

