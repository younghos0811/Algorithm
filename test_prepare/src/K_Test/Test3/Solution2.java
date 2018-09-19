package K_Test.Test3;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution2 {

    int answer = 0;
    String[][] relation;
    int colSize = 0;
    int rowSize = 0;

    public int solution(String[][] relation) {
        answer = 0;
        this.relation = relation;
        colSize = relation[0].length;
        rowSize = relation.length;

        for(int i = 0; i < colSize; i++) {
            int[] keyArr = new int[1];
            keyArr[0] = i;
            func(keyArr);
        }

        return answer;
    }

    private void func(int[] keys) {
        if(isUnique(keys)) {
            answer++;
            return;
        }

        if(keys.length == colSize)
            return;

        int[] newKeys = new int[keys.length + 1];

        for(int i = 0; i < keys.length; i++) {
            newKeys[i] = keys[i];
        }

        for(int i = keys[keys.length-1] + 1; i < colSize; i++) {
            newKeys[newKeys.length-1] = i;
            func(newKeys);
        }


    }


    private boolean isUnique(int[] arr){
        String[] sum  = new String[rowSize];
        Arrays.fill(sum , "");

        for(int i = 0; i < arr.length; i++) {
            int keyNum = arr[i];
            int j = 0;
            for(String[] row : relation) {
                sum[j] += "||" + row[keyNum];
                j++;
            }
        }

        Map<String, Boolean> checkMap = new HashMap<>();
        for(int i = 0; i < sum.length; i++) {
            if(checkMap.get(sum[i]) != null) {
                return false;
            }
            checkMap.put(sum[i],true);
        }
        return true;
    }

}
