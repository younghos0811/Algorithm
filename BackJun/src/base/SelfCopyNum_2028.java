package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/2028
 *
 */

public class SelfCopyNum_2028 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String result = "";

        while(T-- > 0) {
            String numStr = br.readLine();
            String powerNumStr = (int)Math.pow(Integer.parseInt(numStr) , 2) + "";
            if(isSame(numStr.toCharArray() , powerNumStr.toCharArray()))
               result += "YES\n";
            else
                result += "NO\n";
        }

        System.out.println(result);
    }

    private static boolean isSame(char[] num , char[] powNum) {

        for(int i = 0; i < num.length; i++) {
            if(num[num.length -1 - i] != powNum[powNum.length -1 -i])
                return false;
        }

        return true;

    }
}
