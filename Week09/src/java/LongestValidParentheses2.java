/**
 * @author： chenr
 * @date： Created on 2020/7/19 20:55
 * @version： v1.0
 * @modified By:
 * 最长有效括号
 */
public class LongestValidParentheses2 {
    public static void main(String[] args) {
        String s = "(()";
        int result = new LongestValidParentheses2().longestValidParentheses(s);
        System.out.println(result);
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int maxans = 0;
        int [] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) ==')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i >= 2 ? dp[i-2]:0) + 2;
                }else if (i - dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i-1] + ((i-dp[i-1]) >2 ?dp[i-dp[i-1]-2] :0) + 2;
                }
                maxans = Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }
}
