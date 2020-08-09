/**
 * @author： chenr
 * @date： Created on 2020/8/9 21:27
 * @version： v1.0
 * @modified By:
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "the sky is blue";
        String s1 = " hello world!";
        System.out.println(new ReverseWords().reverseWords(s1));
    }

    public String reverseWords(String s) {
        if (s == null || s == "") {
            return "";
        }
        s = s.trim();
        String[] strings = s.split("\\s+");
        int j = strings.length - 1;
        int i = 0;

        while (i <= j) {
            String temp = strings[i];
            strings[i++] = strings[j];
            strings[j--] = temp;
        }

        return String.join(" ", strings);
    }
}