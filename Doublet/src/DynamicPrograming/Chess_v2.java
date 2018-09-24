package DynamicPrograming;


import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Chess_v2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] whiteArr = new int[1001];
        int[] blackArr = new int[1001];
        int[][][] dp;
        int cnt = 1;
        String input;
        StringTokenizer st;

        /** if use scanner : sc.hasnext or sc.hasNextLine **/
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            whiteArr[cnt] = Integer.parseInt(st.nextToken());
            blackArr[cnt] = Integer.parseInt(st.nextToken());
            cnt++;
        }

        dp = new int[cnt][16][16];
        dp[1][1][0] = whiteArr[1];
        dp[1][0][1] = blackArr[1];

        for(int i = 2; i < cnt; i++) {
            int maxWhiteCnt = (i > 15 ? 15 : i);
            for(int j = 0; j <= maxWhiteCnt; j++) {
                int maxBlackCnt = (i-j > 15 ? 15 : i-j);
                for(int k = 0; k <= maxBlackCnt; k++) {
                    int noSelectVal = dp[i-1][j][k];
                    int selectWhiteVal = (j > 0) ? dp[i-1][j-1][k] + whiteArr[i] : 0;
                    int selectBlackVal = (k > 0) ? dp[i-1][j][k-1] + blackArr[i] : 0;
                    dp[i][j][k] = Math.max(Math.max(noSelectVal , selectBlackVal), selectWhiteVal);
                }
            }

        }
        System.out.println(dp[cnt-1][15][15]);
    }
}
