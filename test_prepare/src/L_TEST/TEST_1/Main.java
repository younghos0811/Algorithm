package L_TEST.TEST_1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        final int MAX_DISTANCE = 178;
        final int MIN_DISTANCE = 4;
        final int DEFAULT_DSITANCE = 40;
        int remainMoney = 20000;
        int[] arr = new int[tokenizer.countTokens()];

        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            arr[i] = distance;
            i++;
        }

        for(int distance : arr) {
            // @todo Write your code here.
            int thisTimePay = 720;

            if(distance > MAX_DISTANCE || distance < MIN_DISTANCE) {
                break;
            }
            else if(distance > DEFAULT_DSITANCE){
//                thisTimePay += ((int)((distance-40)/8))*80;
                distance -= 40;

                while(distance > 0) {
                    thisTimePay += 80;
                    distance -= 8;
                }

            }

            if(remainMoney - thisTimePay < 0) {
                break;
            }
            else
                remainMoney -= thisTimePay;
;
        }

        System.out.println(remainMoney);
        // @todo Write your code here.
    }

}
