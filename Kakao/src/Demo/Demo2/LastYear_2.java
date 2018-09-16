package Demo.Demo2;


//^ : 문자열의 시작을 나타냄
//
//$ : 문자열의 종료를 나타냄
//
//. : 임의의 한문자를 나타냄
//
//I : or를 나타냄
//
//[] : 문자열 클래스 지정시 사용
//
//\w : 알파벳이나 숫자
//
//\W : 알파벳이나 숫자를 제외한 문자
//
//\d : 숫자 [0-9]와 동일
//
//
//
//출처: http://superfelix.tistory.com/70 [☼ 꿈꾸는 도전자 Felix !]

//https://nesoy.github.io/articles/2018-06/Java-RegExp 여기 표 형식


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastYear_2 {

    private enum NUMS {
        Z,S,D,T
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
//        String regEx = "[0-9][0-9]*[A-Z]\\**\\#*";
        String regEx = "(\\d{1,2})([A-Z]{1})([*#]?)";

        Pattern pat = Pattern.compile(regEx);
        Matcher match = pat.matcher(target);

        //this game
        int preNum = 0;
        int sum = 0;
        while (match.find()) {
            int point = Integer.parseInt(match.group(1));
            String option = match.group(2);
            String option2 = match.group(3);
            point = (int)Math.pow(point , NUMS.valueOf(option).ordinal());
            if(option2.length() == 1) {
                if(option2.equals("*")) {
                    sum += preNum;
                    point *= 2;
                }
                else {
                    point *= -1;
                }
            }
            preNum = point;
            sum += point;
        }

        System.out.println(sum);


    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}
