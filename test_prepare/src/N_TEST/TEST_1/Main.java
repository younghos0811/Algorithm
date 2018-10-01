package N_TEST.TEST_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < C; i++) {
            list.add(i + 1);
        }

        int P = Integer.parseInt(br.readLine());

        while(P-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> lastList = new ArrayList<>();

            while(list.size() > N*2) {

                int i = 0;
                while(i < N) {
                    lastList.add(0 , list.remove(list.size()-1));
                    i++;
                }

                i = 0;
                while(i < N) {
                    lastList.add(0 , list.remove(N-i-1));
                    i++;
                }

            }

            for(int i = 0; i < lastList.size(); i++) {
                list.add(lastList.get(i));
            }


        }

        for(int i = 0; i < 5; i++)
            System.out.println(list.get(i));



    }
}



