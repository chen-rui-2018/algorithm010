/**
 * @author： chenr
 * @date： Created on 2020/8/14 11:33
 * @version： v1.0
 * @modified By:
 */
public class RemoveElement {
    public static void main(String[] args) {
        int [] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(new RemoveElement().removeElement(nums,val));
    }
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }
}
