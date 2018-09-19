package Algorithm_Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_EXample {
    public static void main(String[] args) {
        String target = "1T2D3D#";
        String regEx = "[0-9][0-9]*[A-Z]\\**\\#*";
        // more https://nesoy.github.io/articles/2018-06/Java-RegExp

        Pattern pat = Pattern.compile(regEx);
        Matcher match = pat.matcher(target);

        int matchCount = 0;
        while (match.find()) {
            System.out.println(matchCount + " : " + match.group());
            matchCount++;
        }
    }
}
