package DataStructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Match {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                stack.push(i);

            }
            else if(arr[i] == ')') {
                if(stack.isEmpty()) {
                    System.out.println("not match");
                    return;
                }
                sb.append(stack.pop() + " " + i + "\n");
            }
        }

        if(!stack.isEmpty())
            System.out.println("not match");
        else
            System.out.println(sb.toString());
    }
}
