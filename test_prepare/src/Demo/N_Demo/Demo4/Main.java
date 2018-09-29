package Demo.N_Demo.Demo4;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static private int[][] numArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solution(arr);
    }

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
            System.out.print(que.poll() + " ");
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


