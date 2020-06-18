import sun.rmi.runtime.NewThreadAction;

import java.util.HashMap;

/**
 * @author： chenr
 * @date： Created on 2020/6/15 22:58
 * @version： v1.0
 * @modified By:
 * 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        int [] nums = {11, 7, 2, 15};
        int target = 9;
        int [] aim = new TwoSum().twoSum(nums,target);
        System.out.println(aim[0]+","+aim[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length;i++){
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
