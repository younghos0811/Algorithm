package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int answer=0;

        int N=sc.nextInt();
        sc.nextLine();
        int[][] arr=new int[N][N];
        int[] checkArr=new int[N];

        for(int i=0; i<N; i++){
            //String[] inputArr=sc.nextLine().split(" ");
            for(int j=0; j<N; j++){
                //arr[i][j]=Integer.parseInt(inputArr[j]);
                arr[i][j]=sc.nextInt();
            }
        }

        int count=1;
        checkArr[0]=1;
        while(true){
            if(count==N)
                break;
            int min=Integer.MAX_VALUE;
            int minIndex=-1;
            for(int i=0; i<N; i++){
                if(checkArr[i]==0)
                    continue;
                for(int j=0; j<N; j++){
                    if(checkArr[j]==1||i==j)
                        continue;
                    if(arr[i][j]<min){
                        min=arr[i][j];
                        minIndex=j;
                    }
                }
            }

            answer+=min;
            checkArr[minIndex]=1;
            count++;
        }


        System.out.println(answer);

    }

}