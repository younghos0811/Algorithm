package fullSearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Java7 이후로는 switch 문을 사용할 때

'문자열'을 사용할 수 있게 되었습니다.

 */

public class Set {

    enum Cmd {add,remove,check,toggle,all,empty} ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int s = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cnt; i++) {
            String[] cmds = br.readLine().split(" ");
            int num = 0;
            int cmd = Cmd.valueOf(cmds[0]).ordinal();

            switch (cmd) {
                case 0:
                    num = Integer.parseInt(cmds[1]);
                    s = s | (1 << num);
                    break;
                case 1:
                    num = Integer.parseInt(cmds[1]);
                    s = s & ~(1 << num);
                    break;
                case 2:
                    num = Integer.parseInt(cmds[1]);
                    if ((s & (1 << num)) > 0)
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case 3:
                    num = Integer.parseInt(cmds[1]);
                    s = s ^ (1 << num);
                    break;
                case 4:
                    s = (s << 21) - 1;
                    break;
                case 5:
                    s = 0;
                    break;
            }


/*  #use String switch문  //이렇게 하는게 살짝 속도는 빠른듯
            switch (cmds[0]) {
                case "add":
                    num = Integer.parseInt(cmds[1]);
                    s = s | (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(cmds[1]);
                    s = s & ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(cmds[1]);
                    if ((s & (1 << num)) > 0)
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(cmds[1]);
                    s = s ^ (1 << num);
                    break;
                case "all":
                    s = (s << 21) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
            }

            */
        }
        System.out.println(sb.toString());
    }

}
