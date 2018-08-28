package base;


import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstNum = Integer.parseInt(br.readLine());
        int left = (firstNum%10)*10;
        int right = (firstNum/10+firstNum%10)%10;
        int result = left + right;
        int cnt = 1;

        while(result != firstNum){
            left = (result%10)*10;
            right = (result/10+result%10)%10;
            result = left + right;
            cnt++;
        }

        System.out.println(cnt);



    }
}

