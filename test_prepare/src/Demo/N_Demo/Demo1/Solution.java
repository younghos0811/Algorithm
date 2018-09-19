package Demo.N_Demo.Demo1;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final int MAX_VAL = 3;

    public static void solution(int[] arr) {
        List<Integer> list = new ArrayList<>(3);
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(list.contains(arr[i])) {
                list.remove(Integer.valueOf(arr[i]));
            }
            else if(list.size() == MAX_VAL) {
                sb.append(list.remove(0) + "\n");
                cnt++;
            }
            list.add(arr[i]);
        }

        if(cnt == 0)
            System.out.println(0);
        else {
            System.out.println(sb.toString());
        }
    }
}
