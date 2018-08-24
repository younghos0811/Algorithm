package Greed;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LosedDongGeon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line =  br.readLine();
        int currentNum = 0;
        int firstMinus = line.indexOf('-');

        if(firstMinus > 0) {
            String[] plusLines = line.substring(0,firstMinus).split("\\+");
            for(String plus : plusLines) {
                currentNum += Integer.valueOf(plus);
            }

            String[] minusLine = line.substring(firstMinus+1,line.length()).split("\\-|\\+");
            for(String minus : minusLine) {
                currentNum -= Integer.valueOf(minus);
            }
        }
        else {
            String[] plusLines = line.split("\\+");
            for(String plus : plusLines) {
                currentNum += Integer.valueOf(plus);
            }
        }

        System.out.println(currentNum);
    }
}
