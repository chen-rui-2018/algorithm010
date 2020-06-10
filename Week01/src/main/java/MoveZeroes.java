/**
 * @author： chenr
 * @date： Created on 2020/6/10 22:33
 * @version： v1.0
 * @modified By:
 * 移动0题目
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int [] arr = {0,1,0,3,12,-1,0,1};
        int [] arr2 = {1};
        moveZeroes1(arr);
        System.out.println();
        moveZeroes1(arr2);
        System.out.println();
        moveZeroes2(arr);
    }

    private static void moveZeroes2(int[] nums) {
        if(nums == null) {
            return;
        }
        int j =0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        for(int i=0; i<nums.length;i++){
            System.out.print(nums[i]+",");
        }
    }

    public static void moveZeroes1(int[] nums) {
        if(nums == null) {
            return;
        }
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for(int i=j; i<nums.length; i++) {
            nums[i] = 0;
        }

        for(int i=0; i<nums.length;i++){
            System.out.print(nums[i]+",");
        }
    }
}
