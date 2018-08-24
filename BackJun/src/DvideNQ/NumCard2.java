package DvideNQ;

//tokenizer를 써보자
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumCard2 {

    static final int MAX_NUM = 20000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.valueOf(br.readLine());
        int[] checkCards = new int[MAX_NUM] ;
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cnt; i++) {
            checkCards[Integer.valueOf(tokenizer.nextToken()) + 10000000]++ ;
        }

        cnt = Integer.valueOf(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());

        for(int i = 0; i < cnt; i++) {
            sb.append(checkCards[Integer.valueOf(tokenizer.nextToken())+10000000] + " ");
        }

        System.out.println(sb.toString());

    }
}
