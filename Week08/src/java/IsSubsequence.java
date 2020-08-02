import java.util.concurrent.ForkJoinPool;

/**
 * @author： chenr
 * @date： Created on 2020/7/27 14:44
 * @version： v1.0
 * @modified By:
 * 判断子序列
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "123";
        String t = "14253";

        System.out.println(new IsSubsequence().isSubsequence(s,t));
        System.out.println(new IsSubsequence().isSubsequence1(s,t));
    }
    public boolean isSubsequence(String s, String t) {
      int sLength = s.length();
      int tLength = t.length();
      int i = 0;
      int j = 0;
      while(i < sLength && j<tLength){
          if (s.charAt(i) == t.charAt(j)) {
              i++;
          }
          j++;
      }
      return i == sLength;
    }
    public boolean isSubsequence1(String s, String t) {
     if(s.length() == 0){
         return true;
     }
     boolean [][] dp = new boolean[s.length()+1][t.length()+1];
        for (int i = 0; i < t.length(); i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
