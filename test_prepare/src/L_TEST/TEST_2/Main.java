package L_TEST.TEST_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // path 0 F , 1 R, 2L , 3B
    private static int[][] pathMap = {{0,1,2,3},{1,3,0,2},{2,0,3,1},{3,2,1,0}};

    private static int[] dirX = {0,1,-1,0};  //l ,r
    private static int[] dirY = {-1,0,0,1};  //u ,d

    private static boolean[][] isVisit;

    private static class Node {
        int x = 0;
        int y = 0;
        int path = 0;
        int len = 0;
        boolean[] isPath = new boolean[4];
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        isVisit = new boolean[N][N];
        Node[][] nodeMap = new Node[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                Node node = new Node();
                char[] infoArr = st.nextToken().toCharArray();
                node.path = getNum(infoArr[0]);
                node.len = Character.getNumericValue(infoArr[1]);
                node.x = j;
                node.y = i;
                nodeMap[i][j] = node;
            }
        }
        int x = 0;
        int y = 0;
        int prePath = 3;
        while(true) {

            int nextPath = pathMap[prePath][nodeMap[y][x].path];
            Node node = nodeMap[y][x];

            if(isVisit[y][x]) {
                if(node.isPath[nextPath]) {
                    System.out.println(x + " " + y);
                    break;
                }
                else
                    node.isPath[nextPath] = true;
            }
            else {
                isVisit[y][x] = true;
                for(int i = 0; i < node.len; i++) {
                    x += dirX[nextPath];
                    y += dirY[nextPath];
                }
                prePath = nextPath;

            }
        }

    }

    private static int getNum(char ch) {
        if(ch == 'F')
            return 0;
        if(ch == 'R')
            return 1;
        if(ch == 'L')
            return 2;
        if(ch == 'B')
            return 3;

        return -1;
    }
}
