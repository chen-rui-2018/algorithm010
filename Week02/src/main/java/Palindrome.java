/**
 * @author： chenr
 * @date： Created on 2020/6/19 17:29
 * @version： v1.0
 * @modified By:
 * 每日一题:验证回文串
 */
public class Palindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        String str1 = "1233421";

       boolean flag= new Palindrome().isPalindrome(str1);
       System.out.println(flag);
    }
    public boolean isPalindrome(String s) {

        char [] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<chars.length;i++) {
            if(Character.isLetterOrDigit(chars[i])){
                sb.append(chars[i]);
            }
        }
        chars = sb.toString().toLowerCase().toCharArray();
        int j = chars.length-1;

         for (int i=0;i< chars.length/2+1;i++){
             if(i>=j){
                 break;
             }
            if (chars[i] != chars[j--]){
                return  false;
            }

        }
     return true;
    }
}
