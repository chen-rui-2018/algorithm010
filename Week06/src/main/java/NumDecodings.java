/**
 * @author： chenr
 * @date： Created on 2020/7/17 15:31
 * @version： v1.0
 * @modified By:
 * 解码方法
 */
public class NumDecodings {
    public static void main(String[] args) {
      String s = "226";
        int  result =  new NumDecodings().numDecodings(s);
        System.out.println(result);
    }
    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int [] dp = new int[length];
        dp[0] = 0;
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0'){
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            if(charArray[i] != '0') {
                dp[i] = dp[i-1];
            }
            int num = 10 * (charArray[i-1]-'0')+(charArray[i]-'0');
            if (num > 10 && num <= 26) {
                if (i==1){
                    dp[i]++;
                }else {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[length-1];
    }
}
