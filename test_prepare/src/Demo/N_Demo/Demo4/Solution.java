package Demo.N_Demo.Demo4;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    static private int[][] numArr;
    public static void solution(int[][] arr) {

        numArr = arr;
        int cnt = 0;
        Queue<Integer> que = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(numArr[i][j] == 1) {
                    que.offer(search(i,j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        while(!que.isEmpty()) {
            System.out.println(que.poll());
        }
    }

    private static int search(int x, int y) {
        numArr[x][y] = 0;
        int sum = 1;

        if(x > 0 && numArr[x-1][y] == 1)
            sum += search(x-1 , y);
        if(y > 0 && numArr[x][y-1] == 1)
            sum += search(x , y-1);
        if(x < numArr.length-1 && numArr[x+1][y] == 1)
            sum += search(x+1 , y);
        if(y < numArr.length-1 && numArr[x][y+1] == 1)
            sum += search(x , y+1);
        return sum;
    }
}
