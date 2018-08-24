package DvideNQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NumberCard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.valueOf(br.readLine());
        Map<String, Boolean> map = new HashMap<String, Boolean>();

        for(String s : br.readLine().split(" ")) {
            map.put(s, true);
        }

        cnt = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(String s : br.readLine().split(" ")) {
           if(map.get(s) == null)
              sb.append("0 ");
           else
               sb.append("1 ");
        }

        System.out.println(sb.toString());


    }


}
