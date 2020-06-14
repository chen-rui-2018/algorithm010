/**
 * @author： chenr
 * @date： Created on 2020/6/14 23:17
 * @version： v1.0
 * @modified By:
 * 删除排序数组中的重复项
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int [] array = {0,0,1,1,1,2,2,3,3,4};
         System.out.println(removeDuplicates.removeDuplicates(array));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i=0;
        int num=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i] != nums[j]){
                num++;
            }
            i++;
        }
        return num+1;
    }
}
