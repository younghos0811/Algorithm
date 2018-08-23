package fullSearch;

/*
문제
비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.

add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다.
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다.
입력
첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.

둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.

출력
check 연산이 주어질때마다, 결과를 출력한다.

예제 입력 1
26
add 1
add 2
check 1
check 2
check 3
remove 2
check 1
check 2
toggle 3
check 1
check 2
check 3
check 4
all
check 10
check 20
toggle 10
remove 20
check 10
check 20
empty
check 1
toggle 1
check 1
toggle 1
check 1
예제 출력 1
1
1
0
1
0
1
0
1
0
1
1
0
0
0
1
0
*/


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
