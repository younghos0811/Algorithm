package L_TEST.TEST_3;


import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] notes = new int[N][];
        int max = 0;
        for(int i=0; i<notes.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            notes[i] = new int[st.countTokens()];
            for(int j=0; j<notes[i].length; j++) {
                notes[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, notes[i][j]);
            }
        }
        br.close();


        parent = new int[max+1];
        for(int i=1; i<parent.length; i++) {
            parent[i] = i;
        }

        for(int i=0; i<notes.length; i++) {
            for(int j=0; j<notes[i].length-1; j++) {
                if(!union(notes[i][j], notes[i][j+1])) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<parent.length; i++) {
            if(parent[i] == i) {
                res.add(i);
            }
        }
        Collections.sort(res);

        for(int i=1; i<parent.length; i++) {
            if(parent[i] == i) {
                System.out.print(i + " ");
            }
        }
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB) {
            if(parentA != a) {
                return false;
            }
            parent[parentA] = parentB;
        }
        return true;
    }

}