package K_Test.Test3;


import java.util.Arrays;

public class Solution_MW {


    public int solution(String[][] relation) {
        int row = relation[0].length;
        int col = relation.length;

        final int MAX_BIT = (1<<row) - 1;

        boolean[] isKey = new boolean[row];
        Arrays.fill(isKey, false);

        int cnt = 0;
        for(int i=1; i<=MAX_BIT; i++) {
            String[] key = createKeySet(relation, i, isKey);

            if(key != null) {
                if(isUnique(key)) {  // 현재 값이 key일 경우
//                System.out.println("key is :" + Integer.toBinaryString(i));
                    cnt++;
                    for(int j=0; j<row; j++) {
                        if((i & (1<<j)) != 0) {
                            isKey[j] = true;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    public static String[] createKeySet(String[][] relation, int bitMask, boolean[] isKey) {
        int row = relation[0].length;
        int col = relation.length;

        // key로 사용한 비트(열)가 있는지 체크
        for(int i=0; i<row; i++) {
            if((bitMask & (1<<i)) != 0) {  // 비트 자리가 1 여부 체크
                if(isKey[i]) {
                    return null;  // key로 사용한 적이 있을 경우 null 리턴
                }
            }
        }

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