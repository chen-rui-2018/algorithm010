import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/7/10 10:58
 * @version： v1.0
 * @modified By:
 * 三数之和
 */
public class ThreeSum {
    public static void main(String[] args) {
        int [] nums  = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new ThreeSum().threeSum(nums);
        System.out.println();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hashSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2 ; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int target = 0;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else if (sum == target) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[left]);
                    curr.add(nums[right]);
                    if (!hashSet.contains(curr)) {
                        hashSet.add(curr);
                        result.add(curr);
                    }
                    left++;
                    right--;

                }
            }
        }
        return  result;
    }
}
