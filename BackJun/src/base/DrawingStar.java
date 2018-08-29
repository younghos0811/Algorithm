package base;

import java.util.Scanner;

public class DrawingStar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] lines  = new String[n];
        int lastLen = 3;
        lines[0] = "  *  ";
        lines[1] = " * * ";
        lines[2] = "*****";

        for(int i = 1; 3*Math.pow(2,i) <= n; i++) {
            int spaceSize = (3*(int)Math.pow(2,i))/2;
            String space = "";

            //add new starts
            for(int j = 0; j < lastLen;j++) {
                lines[lastLen + j] = lines[j] + " " + lines[j];
            }

            for(int j = 0; j < spaceSize; j++)
                space += " ";

            for(int j = 0; j < lastLen;j++) {
                lines[j] = space + lines[j] + space;
            }

            lastLen *= 2;

        }

        for(int i = 0; i < n; i++)
            System.out.println(lines[i]);


    }

}
