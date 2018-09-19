package Demo.N_Demo.Demo2;

import java.util.StringTokenizer;

public class Solution {

    private static final int START_NUM = 97;
    private static final int BACK_START_NUM = 123; // Z is 122  (minus to 123 -1)

    public static String solution(String str) {
        StringTokenizer st = new StringTokenizer(str);
        String cmd = st.nextToken();
        String key =st.nextToken();
        int rotationCnt = Integer.parseInt(st.nextToken());
        String msg = st.nextToken();
        char[] msgArr = msg.toCharArray();

        if(cmd.equals("encrypt")) {
            //암호화 시행
            msgArr = msg.toCharArray();
            msgArr = encrtpyKey(msgArr , key.toCharArray());
            msgArr = rotation(msgArr , rotationCnt);
        }

        if(cmd.equals("decrypt")) {
            //암호화 시행
            msgArr = msg.toCharArray();
            msgArr = rotation(msgArr , rotationCnt * -1);
            msgArr = decrtpyKey(msgArr , key.toCharArray());
        }

        return String.valueOf(msgArr);
    }

    private static char[] encrtpyKey(char[] msg , char[] key) {

        for(int i = 0; i < msg.length; i++) {
            msg[i] = (char)((97 + ((msg[i] - 97) + (key[i]-97))%26));
        }

        return msg;
    }

    private static char[] decrtpyKey(char[] msg , char[] key) {

        for(int i = 0; i < msg.length; i++) {
            int gabNum = ((msg[i] - 97) - (key[i] - 97)) % 26;
            if (gabNum < 0)
                msg[i] = (char) (BACK_START_NUM + gabNum);
            else
                msg[i] = (char) (START_NUM + gabNum);
        }

        return msg;
    }

    private static char[] rotation(char[] msg , int rotationCnt) {
        char[] newMsg = new char[msg.length];
        rotationCnt = rotationCnt%msg.length;

        if(rotationCnt < 0)
            rotationCnt = msg.length + rotationCnt;

        for(int i = rotationCnt; i < (msg.length + rotationCnt); i++) {
            newMsg[i-rotationCnt] = msg[i%msg.length];
        }
        return newMsg;
    }
}
