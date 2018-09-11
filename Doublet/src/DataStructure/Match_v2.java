package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Match_v2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int stack = 0;
        int[] indexArr = new int[arr.length];
        int index = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                indexArr[index] = i;
                index++; // number index ++
                stack++; //push
            }
            else if(arr[i] == ')'){
                if(stack == 0) {
                    System.out.println("not match");
                    return;
                }
                else {
                    sb.append(indexArr[index-1] + " " + i + "\n");
                    stack--;
                    index--;
                }
            }
        }

        if(stack != 0)
            System.out.println("not match");
        else
            System.out.println(sb.toString());
    }
}
