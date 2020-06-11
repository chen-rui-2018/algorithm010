import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/6/11 22:50
 * @version： v1.0
 * @modified By:
 */
public class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        int [] nums = {2, 7, 11, 15};
        int target = 17;
        int [] aim = solution.twoSum(nums,target);
        for (int i=0; i<aim.length;i++){
            System.out.print(aim[i]+",");
        }
        System.out.println();
        int [] aim1 = solution.twoSum1(nums,target);
        for (int i=0; i<aim.length;i++){
            System.out.print(aim[i]+",");
        }
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //暴力破解 时间复杂度 O(n^2)
        public int[] twoSum(int[] nums, int target) {
            // 目标数组,存返回数组
            int [] aim = new int[2];
            for (int i = 0; i<nums.length-1; i++){
                for (int j=i+1;j<nums.length; j++) {
                    if(nums[i] + nums [j] == target){
                        aim[0] = i;
                        aim[1] = j;
                        break;
                    }
                }
            }
            return aim;
        }
        // 两遍哈希表
        public int[] twoSum1(int[] nums, int target) {
            // hashMap 保存 一遍 nums 的值;
            Map<Integer,Integer> map = new HashMap<>(16);
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],i);
            }

            for (int i = 0; i < nums.length; i++){
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[]{i,map.get(complement)};
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
        // 一遍hash 表
        public int[] twoSum2(int[] nums, int target) {
            // hashMap 保存 一遍 nums 的值;
            Map<Integer,Integer> map = new HashMap<>(16);
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if(map.containsKey(complement)){
                    return new int[]{map.get(complement),i};
                }
                map.put(nums[i],i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
