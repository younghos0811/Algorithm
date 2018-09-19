package Demo.K_Demo.Demo3;

import java.util.Arrays;
import java.util.Scanner;

public class LastYear_3 {

    private static class Node implements Comparable<Node> {
        private int useCnt = 0;
        private int inputNum = 0;
        String name;

        public Node(int inputNum , String name) {
            this.inputNum = inputNum;
            this.name = name;
        }

        public void addUseCnt() {
            useCnt++;
        }

        @Override
        public int compareTo(Node o) {
            if(this.useCnt > o.useCnt)
                return 1;
            else if(this.useCnt < o.useCnt)
                return -1;
            else {
                return this.inputNum - o.inputNum;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cacheSize = sc.nextInt();
        Node[] cache = new Node[cacheSize];
        int useCacheSize = 0;
        int sum = 0;

//        String cities[] = {"Jeju" , "Pangyo", "NewYork" , "newyork"};
//        String cities[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String cities[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        if(cacheSize == 0) {
            System.out.println(cities.length*5);
            return;
        }
        for(int i = 1; i <= cities.length; i++) {
            Node node = new Node(i,cities[i-1].toUpperCase());
            if(useCacheSize < cacheSize) {
                cache[useCacheSize] = node;
                sum += 5;
                useCacheSize++;
            }
            else {
                if(ishit(node.name,cache,useCacheSize)) {
                    //hit
                    sum += 1;
                }
                else {
                    //miss
                    Arrays.sort(cache);
                    sum += 5;
                    cache[0] = node;
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean ishit(String city , Node[] cache , int useCacheSize) {
        for(int i = 0; i < useCacheSize; i++) {
            if(cache[i].name.equals(city)) {
                cache[i].addUseCnt();
                return true;
            }
        }

        return false;
    }
}
