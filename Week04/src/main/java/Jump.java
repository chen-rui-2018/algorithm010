/**
 * @author： chenr
 * @date： Created on 2020/7/5 23:00
 * @version： v1.0
 * @modified By:
 * 跳跃游戏 II
 */
public class Jump {
    public static void main(String[] args) {
        int []  nums = {2,3,1,1,4};
        System.out.println(new Jump().jump(nums));
    }
    public int jump(int[] nums) {
        int position = nums.length-1;
        int steps = 0;
        while (position > 0 ) {
            for (int i = 0;i < position; i++){
                if (i+nums[i] >= position){
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
