package Demo.L_DEMO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main3 {

    static Map<Integer , Integer> map = new HashMap<>();
    private static int find(int x) {
        int mapNum = map.get(x);
        if(x == mapNum)
            return x;

        return find(mapNum);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            map.put(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(cnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(!map.containsKey(x))
                map.put(x,x);
            if(!map.containsKey(y))
                map.put(y,y);

            union(x,y);

        }

        Iterator<Integer> keyset = map.keySet().iterator();
        Map<Integer , Boolean> checkMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();


        while(keyset.hasNext()) {
            Integer num = find(keyset.next());
            if(!list.contains(num))
                list.add(num);
        }

        System.out.println(list.size());

    }
}
