/**
 * @author： chenr
 * @date： Created on 2020/8/9 21:45
 * @version： v1.0
 * @modified By:
 */
public class ReverseWords3 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println( new ReverseWords3().reverseWords(s));


    }
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
}
