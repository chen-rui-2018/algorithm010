/**
 * @author： chenr
 * @date： Created on 2020/8/8 9:17
 * @version： v1.0
 * @modified By:
 */
public class SearchInsert {
    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        int target =2 ;
        System.out.println(new SearchInsert().searchInsert(nums,target));
    }
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
                right --;
            }
            if (nums[mid] < target){
                left = mid;
                left ++;
            }

        }
        return left;
    }
}
