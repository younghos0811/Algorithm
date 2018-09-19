package Demo.N_Demo.Demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[][] arr = new char[size][size];

        for(int i = 0; i < size; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < size; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        int[][] newMap = Soltuion.solution(arr);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(newMap[i][j] + " ");
            }
            System.out.println();
        }

    }
}
