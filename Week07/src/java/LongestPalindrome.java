/**
 * @author： chenr
 * @date： Created on 2020/7/25 13:36
 * @version： v1.0
 * @modified By:
 * 最长回文子串
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "aabbaa";
        System.out.println( new LongestPalindrome().longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        if (s  == null || s.length() < 1) {
            return "";
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len > right - left){
                left = i - (len-1)/2;
                right = i + len/2;
            }
        }
        return s.substring(left,right+1);
    }

    private int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
