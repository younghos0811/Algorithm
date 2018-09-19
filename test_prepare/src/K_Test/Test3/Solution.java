package K_Test.Test3;

import java.util.*;

class Solution {

    int answer = 0;
    String[][] relation;
    int colSize = 0;
    int rowSize = 0;
    List<int[]>[] list;

    public int solution(String[][] relation) {
        answer = 0;
        this.relation = relation;
        colSize = relation[0].length;
        rowSize = relation.length;
        list = new List[colSize];

        for(int i = 0; i < colSize; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < colSize; i++) {
            int[] keyArr = new int[1];
            keyArr[0] = i;
            func(keyArr);
        }

        // 여기서 최소성을 없애자.
        for(int i = 0; i < colSize-1; i++) {
            List<int[]> thisTimeList = list[i];
            for(int k = 0; k < thisTimeList.size(); k++) {
                int[] preKeys = thisTimeList.get(k);
                for(int j = i+1; j < colSize; j++) {
                    //각 차원들
                    List<int[]> nextTimeList = list[j];
                    int size = nextTimeList.size();
                    int t = 0;
                    int z = 0;
                    while(t < size) {
                        int[] nextKeys = nextTimeList.get(z);
                        if(isContainArr(preKeys,nextKeys)) {
                            nextTimeList.remove(nextKeys);
                            z--;
                        }
                        z++;
                        t++;

                    }
                }
            }
        }

        for(int i = 0; i < colSize; i++) {
            List<int[]> thisTimeList = list[i];
            answer += thisTimeList.size();
        }



        return answer;
    }

    private void func(int[] keys) {
        if(isUnique(keys)) {
//            answer++;
            list[keys.length-1].add(keys);
            return;
        }

//        int[] newKeys = new int[keys.length + 1];
//
//        for(int i = 0; i < keys.length; i++) {
//            newKeys[i] = keys[i];
//        }

        for(int i = keys[keys.length-1] + 1; i < colSize; i++) {
            int[] newKeys = new int[keys.length + 1];

            for(int j = 0; j < keys.length; j++) {
                newKeys[j] = keys[j];
            }
            newKeys[newKeys.length-1] = i;
            func(newKeys);
        }


    }

    private boolean isContainArr(int[] preKeys , int[] nextKeys) {
        for(int i = 0 ; i < preKeys.length; i++) {
            int num = preKeys[i];
            boolean isContain = false;
            for(int j = 0; j < nextKeys.length; j++) {
                if(nextKeys[j] == num) {
                    isContain = true;
                    break;
                }
            }
            if(!isContain)
                return false;
        }

        return true;
    }


    private boolean isUnique(int[] arr){
        String[] sum  = new String[rowSize];

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
