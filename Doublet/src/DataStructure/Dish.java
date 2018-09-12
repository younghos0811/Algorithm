package DataStructure;

/**
 * stack이 가장 유용하게 쓰이는 케이스
 * 가능 여부는 계속 한칸씩 전진하면서 peek을확인하여서 그떄마다 뺴면됨.
 *
 * Goal의 맨 처음은 스택의 peek인것을 기억하자 !
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Dish {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int thisNum = 97;
        final int MAX_NUM = 96+arr.length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {

            while(stack.isEmpty() || stack.peek() != arr[i]) {
                if(thisNum > MAX_NUM) {
                    System.out.println("impossible");
                    return;
                }

                sb.append("push\n");
                stack.push((char)thisNum);
                thisNum++;
            }

            sb.append("pop\n");
            stack.pop();
        }

        System.out.println(sb.toString());
    }
}
