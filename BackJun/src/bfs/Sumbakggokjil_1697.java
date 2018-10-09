package bfs;

import java.util.*;

/**
 *
 *
 * URL : https://www.acmicpc.net/problem/1697
 *
 *
 */

public class Sumbakggokjil_1697 {

    private static class Node {
        int x = 0;
        int cnt = 0;

        public Node(int x , int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startNum = sc.nextInt();
        int solutionNum = sc.nextInt();
        Map<Integer,Boolean> visitMap = new HashMap<>();
//        boolean[] visitMap = new boolean[];
//        visitMap.put(startNum , true);

        if(startNum == solutionNum) {
            System.out.println(0);
            return;
        }

        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(startNum , 0));

        while(!que.isEmpty()) {
            Node node = que.poll();

            for(int i = 0; i < 3; i++) {
                int nextNum = getNewNum(node.x , i);

                if(nextNum < 0)
                    continue;

                if(nextNum > 200001)
                    continue;

                if(visitMap.get(nextNum) != null)
                    continue;

                if(nextNum == solutionNum) {
                    System.out.println(node.cnt + 1);
                    return;
                }

                que.add(new Node(nextNum , node.cnt + 1));
                visitMap.put(nextNum , true);
            }
        }
    }

    private static int getNewNum(int x , int caseNum) {
        switch (caseNum) {
            case 0:
                return x + 1;
            case 1:
                return x - 1;
            case 2:
                return x * 2;
            default:
                return x;
        }
    }
}
