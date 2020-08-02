/**
 * @author： chenr
 * @date： Created on 2020/7/30 10:34
 * @version： v1.0
 * @modified By:
 *
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(10));
    }
    public int integerBreak(int n) {
      int [] dp = new int[n+1];
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],j*Math.max(i-j,dp[i-j]));
            }
        }
        return dp[n];
    }
}
