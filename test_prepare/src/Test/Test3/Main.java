package Test.Test3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Solution s = new Solution();
//        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"}
//        ,{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
//        System.out.println(s.solution(relation));

        List<String> arr = new ArrayList<>();
        arr.add("ss");
        arr.add("bb");
        arr.add("cc");

        int size = arr.size();
        int t = 0;
        int z = 0;
        while(t < size) {
            String s = arr.get(z);
            if(t%2 == 0) {
                arr.remove(s);
                z--;
            }

            System.out.println(s);

            z++;
            t++;

        }

    }
}
