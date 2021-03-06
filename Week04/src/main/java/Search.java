/**
 * @author： chenr
 * @date： Created on 2020/7/5 22:41
 * @version： v1.0
 * @modified By:
 * 搜索旋转排序数组
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;
        System.out.println(new Search().search(nums,target));
    }
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[0] 与 target 的关系判断目标值是在左半段还是右半段
            if (target >= nums[0] ) {
                // 目标值在左半段时，若 mid 在右半段，则将 mid 索引的值改成 inf
                if (nums[mid] < nums[0]){
                    nums[mid] = Integer.MAX_VALUE;
                }
            }else{
                // 目标值在右半段时，若 mid 在左半段，则将 mid 索引的值改成 -inf
                if (nums[mid] < nums[0]){
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            if (nums[mid] < target) {
                lo = mid++;
            }else {
                hi = mid--;
            }
        }
        return -1;
    }
}
