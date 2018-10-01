package N_TEST.TEST_3;


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

    }
}


//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Main {
//
////    상(1), 하(2), 좌(4), 우(8)
//
//
//    private static class Node {
//        int rowIndex = 0;
//        int colIndex = 0;
//        int huddle = 0;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        String[][] map = new String[N][N];
//        StringTokenizer st;
//
//        List<Node> list = new ArrayList<>();
//
//        String lastString = "A";
//
//        for(int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < N; j++) {
//                  map[i][j] = st.nextToken();
//
//                  if(isNumeric(map[i][j])) {
//                      int num = Integer.parseInt(map[i][j]);
//                      Node node = new Node();
//                      node.rowIndex = i;
//                      node.colIndex = j;
//                      node.huddle = num;
//                      list.add(node);
//                  }
//                  else {
//                      if(lastString.compareTo(map[i][j]) < 0) {
//                          lastString = map[i][j];
//                      }
//                  }
//            }
//        }
//
////        System.out.println((int)'A') // 65;
//        String s = "";
//        for(int i = 65; i < (int)lastString.charAt(0); i++) {
//            s += ((char)i) + " " ;
//        }
//        s += lastString;
//
////        System.out.println(s);
//        String[] nanraArr = s.split(" ");
//
//        while(true) {
//            //time while
//            String[][] tempMap = new String[N][N];
//            copyMap(map , tempMap);
//            for(int i = 0; i < N; i++) {
//                for(int j = 0; j < N; j++) {
//                    if(isNumeric(tempMap[i][j])) {
//                        int num = Integer.parseInt(tempMap[i][j]);
//                        int[] naraPoint = new int[nanraArr.length];
//
//                        if((1 & num) != 1 && j < N-1) {
//                            int k = 0;
//                            for(String ss : nanraArr) {
//                                if(ss.equals(map[i-1][j])) {
//                                    naraPoint[k]++;
//                                    break;
//                                }
//                                k++;
//                            }
//                        }
//
//                        if((2 & num) != 2 && j > 0) {
//                            int k = 0;
//                            for(String ss : nanraArr) {
//                                if(ss.equals(map[i][j])) {
//                                    naraPoint[k]++;
//                                    break;
//                                }
//                                k++;
//                            }
//                        }
//
//                        if((4 & num) != 4 && i < N-1) {
//                            int k = 0;
//                            for(String ss : nanraArr) {
//                                if(ss.equals(map[i][j])) {
//                                    naraPoint[k]++;
//                                    break;
//                                }
//                                k++;
//                            }
//                        }
//
//                        if((8 & num) != 8 i > 1) {
//                            int k = 0;
//                            for(String ss : nanraArr) {
//                                if(ss.equals(map[i][j])) {
//                                    naraPoint[k]++;
//                                    break;
//                                }
//                                k++;
//                            }
//                        }
//
//
//                        /** **/
//
//
//                    }
//                }
//            }
//
//        }
//
//
////        System.out.println((int)'0');
////        System.out.println((int)'9');
//
//    }
//
//    private static void copyMap(String[][] source, String[][] dest) {
//        for(int i = 0; i < source.length; i++) {
//            for(int j = 0; j < source[0].length; j++) {
//                dest[i][j] = source[i][j];
//            }
//        }
//    }
//
//    private static boolean isNumeric(String s) {
//        try {
//            Integer.parseInt(s);
//            return true;
//        } catch(NumberFormatException e) {
//            return false;
//        }
//    }
//}
//
//
