/**
 * @author： chenr
 * @date： Created on 2020/7/15 9:06
 * @version： v1.0
 * @modified By:
 *  最长公共子序列
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String test1 = "people";
        String test2 = "eplm";
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(test1,test2));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence2(test1,test2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null  || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int [][] dp = new int [text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null  || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int [] dp = new int [text2.length()+1];
        int temp = 0;
        for (int i = 1; i <= text1.length(); i++) {
            int last = 0;
            for (int j = 1; j <= text2.length(); j++) {
                temp = dp[j];
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                  dp[j] = last + 1;

                }else {
                   dp[j] = Math.max(dp[j-1],dp[j]);
                }
                last = temp;
            }
        }
        return dp[text2.length()];
    }
}
