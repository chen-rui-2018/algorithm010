/**
 * @author： chenr
 * @date： Created on 2020/8/9 21:59
 * @version： v1.0
 * @modified By:
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new LengthOfLIS().lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


}
