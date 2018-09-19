package Demo.N_Demo.Demo3;

public class Soltuion {

    static final int[] DIR= {1,2,4,8}; // 위 왼 오 아
    static final int START_ALPHA = 65;  //'A' is 65

    public static int[][] solution(char[][] map) {
        int row = map.length;
        int col = map[0].length;
        int[][] newMap = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                char num = map[i][j];
                if(num == '0'){
                    newMap[i][j] = -1;
                }
                else {
                    int lv = num - START_ALPHA;
                    int sum = 0;

                    //위쪽 통과 체크
                    if(i > 0 && map[i-1][j] != '0') {
                        sum += DIR[0];
                    }
                    //왼쪽 통과 체크
                    if(j > 0 && map[i][j-1] != '0') {
                        sum += DIR[1];
                    }
                    //오른쪽 통과 체크
                    if(j < col-1 && map[i][j+1] != '0') {
                        sum += DIR[2];
                    }
                    //아래쪽 통과 체크
                    if(i < row-1 && map[i+1][j] != '0') {
                        sum += DIR[3];
                    }
                    newMap[i][j] = sum + 16*lv;
                }
            }
        }

        return newMap;
    }



}
