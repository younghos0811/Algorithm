package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComOrAsist {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int n = Integer.valueOf(splits[0]);
        int m = Integer.valueOf(splits[1]);
        int k = Integer.valueOf(splits[2]);


        int maxTeamCount = 0;

        while(m+n >= k+3 && n>=2 && m>=1){

            maxTeamCount++;
            m--;
            n -= 2;
        }

        System.out.println(maxTeamCount);
    }


}
