package K_Test.Test3;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_MW2 {

    public int solution(String[][] relation) {
        int row = relation[0].length;
        int col = relation.length;

        final int MAX_BIT = (1<<row) - 1;

        ArrayList<Integer> keyList = new ArrayList<>();

        int cnt = 0;
        for(int i=1; i<=MAX_BIT; i++) {
            if(isEnableKey(i, keyList)) {
                String[] key = createKeySet(relation, i, keyList);

                if(isUnique(key)) {  // 현재 값이 key일 경우
//                System.out.println("key is :" + Integer.toBinaryString(i));
                    keyList.add(i);
                    cnt++;
                }
            }
        }

        return cnt;
    }


    public static boolean isEnableKey(int bitMask, ArrayList<Integer> keyList) {
        for(int i : keyList) {
            if((i & bitMask) == i) {
                return false;
            }
        }
        return true;
    }

    public static String[] createKeySet(String[][] relation, int bitMask, ArrayList<Integer> keyList) {
        int row = relation[0].length;
        int col = relation.length;

        // 조사할 key set 생성
        String[] keySet = new String[col];
        for(int i=0; i<col; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<row; j++) {
                if((bitMask & (1<<j)) != 0) {  // 비트 자리가 1 여부 체크
                    sb.append(relation[i][j]);
                }
            }
            keySet[i] = sb.toString();
        }

        return keySet;
    }

    public static boolean isUnique(String[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i].equals(arr[i+1])) {
                return false;
            }
        }
        return true;
    }

}
