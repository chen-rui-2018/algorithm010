/**
 * @author： chenr
 * @date： Created on 2020/7/5 22:22
 * @version： v1.0
 * @modified By:
 *  跳跃游戏
 */
public class CanJump {
    public static void main(String[] args) {
        int [] nums = {3,2,1,0,4};
        System.out.println(  new CanJump().canJump2(nums));

    }
    public boolean canJump(int[] nums) {
      int length = nums.length;
      int rightMost = 0;
        for (int i = 0; i < length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost,i+nums[i]);
                if (rightMost >= length-1) {
                    return true;
                }
            }
        }
      return false;
    }
    public boolean canJump2(int[] nums) {
        int length = nums.length;
        int lastIndex = length-1;
        for (int i = length-2; i >= 0; i--) {
            if (nums[i]+i >= lastIndex) {
               lastIndex =i;
            }
        }
        return lastIndex == 0;
    }

}
