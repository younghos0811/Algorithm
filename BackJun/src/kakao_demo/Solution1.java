package kakao_demo;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

    }

    public boolean solution(int[] arr) {
        Arrays.sort(arr);

        for(int i = 0; i < arr.length -1; i++) {
            if(arr[i+1] - arr[i] != 1)
                return false;
        }

        return true;
    }
}
