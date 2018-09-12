package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {

    static final int[] SUDOKU_CROSS_INDEX_ARR= {0,3,6};
    static int[] arr = new int[81];
    static List<Integer> indexArr = new ArrayList<>();
    static boolean[] isContain = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 0;

        for(int i = 0; i < 9; i++) {

            char[] thisRowArr = br.readLine().toCharArray();
            for(int j = 0; j < 9; j++) {
                arr[i*9 + j] = thisRowArr[j] - '0';
                if(arr[i*9 + j] == 0)
                    indexArr.add(i*9 + j);
            }
        }

        func(-1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(arr[i*9 + j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());




    }

    private static boolean func(int lv) {
        if(lv == indexArr.size()-1) {
            return true;
        }

        int thisIndex = indexArr.get(lv+1);
        for(int i = 1; i <= 9; i++) {
            arr[thisIndex] = i;
            if(isPromise(thisIndex) && func(lv+1)) {
                return true;
            }
            arr[thisIndex] = 0;
        }

        return false;
    }

    /**
     *TODO
     **/
    private static boolean isPromise(int index) {
        int rowIndex = index/9;
        int colIndex = index%9;

        Arrays.fill(isContain , false);
        for(int i = rowIndex*9; i < (rowIndex*9)+9; i++) {
            if(arr[i] == 0)
                continue;;

            if(isContain[arr[i]])
                return false;

            isContain[arr[i]] = true;
        }

        Arrays.fill(isContain , false);
        for(int i = colIndex; i <= colIndex + 72; i = i+9) {
            if(arr[i] == 0)
                continue;;

            if(isContain[arr[i]])
                return false;

            isContain[arr[i]] = true;
        }

        Arrays.fill(isContain , false);
        int startNum = SUDOKU_CROSS_INDEX_ARR[rowIndex/3]*9 + SUDOKU_CROSS_INDEX_ARR[colIndex/3];
        for(int i =0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {
                int thisNumIndex = startNum + i + 9*j;
                if(arr[thisNumIndex] == 0)
                    continue;;

                if(isContain[arr[thisNumIndex]])
                    return false;

                isContain[arr[thisNumIndex]] = true;
            }
        }
        return true;
    }
}
