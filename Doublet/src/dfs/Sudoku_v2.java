package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sudoku_v2 {

    static int[][] arr;
    static List<Position> postionList;

    private static class Position {
        int rowIndex;
        int colIndex;

        public Position(int x , int y){
            rowIndex = x;
            colIndex = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr =new int[9][9];
        postionList= new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            char[] rowStrArr = br.readLine().toCharArray();
            for(int j = 0; j < 9; j++) {
//                arr[i][j] = rowStrArr[j] - '0';
                arr[i][j] = Character.getNumericValue(rowStrArr[j]);

                if(arr[i][j] == 0)
                    postionList.add(new Position(i,j));
            }
        }

        func(0);
        String result = "";

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                result += arr[i][j];
            }
            result += "\n";
        }

        System.out.println(result);
    }

    private static boolean func(int lv) {
        if(lv == postionList.size())
            return true;

        Position position = postionList.get(lv);
        int rowIndex = position.rowIndex;
        int colIndex = position.colIndex;

        for(int i = 1; i <= 9; i++) {
            arr[rowIndex][colIndex] = i;

            if(isPormising(rowIndex,colIndex,i) && func(lv+1))
                return true;

            arr[rowIndex][colIndex] = 0;
        }
        return false;

    }

    private static boolean isPormising(int rowIndex, int colIndex, int num) {

        for(int i = 0; i < 9; i++) {
            if(i != rowIndex && arr[i][colIndex] == num)
                return false;
        }

        for(int i = 0; i < 9; i++) {
            if(i != colIndex && arr[rowIndex][i] == num)
                return false;
        }

        int startRowIndex = rowIndex - rowIndex%3;
        int startColIndex = colIndex - colIndex%3;

        for(int i = startRowIndex; i < startRowIndex + 3; i++) {
            for(int j = startColIndex; j < startColIndex +3; j++) {
                if(i != rowIndex && j != colIndex && arr[i][j] == num)
                    return false;
            }
        }

        return true;
    }



}
