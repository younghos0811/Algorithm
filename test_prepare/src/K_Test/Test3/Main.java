package K_Test.Test3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Solution s  = new Solution();
        Solution3 s3 = new Solution3();
        Solution_MW sm = new Solution_MW();
        Solution_MW2 sm2 = new Solution_MW2();
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"}
        ,{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        long st = System.currentTimeMillis();
        System.out.println(s.solution(relation));
        long ed = System.currentTimeMillis();
        System.out.println("First Solution Time : " + (ed-st));

        st = System.currentTimeMillis();
        System.out.println(s3.solution(relation));
        ed = System.currentTimeMillis();
        System.out.println("Second Solution TimeTime : " + (ed-st));

        st = System.currentTimeMillis();
        System.out.println(sm.solution(relation));
        ed = System.currentTimeMillis();
        System.out.println("MW Solution TimeTime : " + (ed-st));

        st = System.currentTimeMillis();
        System.out.println(sm2.solution(relation));
        ed = System.currentTimeMillis();
        System.out.println("MW2 Solution TimeTime : " + (ed-st));


    }
}
