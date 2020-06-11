/**
 * @author： chenr
 * @date： Created on 2020/6/11 23:23
 * @version： v1.0
 * @modified By:
 * 移动0 第二遍
 */
public class MoveZeroesTwo {
    public static void main(String[] args) {
        int [] arr = {0,1,0,3,12};
        Solution  solution = new MoveZeroesTwo().new Solution();

        solution.moveZeroes(arr);
        System.out.println();
        solution.moveZeroes2(arr);
    }
    class Solution {
        // 双指针, 记录0的个数, 非0元素向前填充,循环完成后,将数组后的0个数位 赋值为0;
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j]=nums[i];
                    j++;
                }
            }
            for (int i = j; i < nums.length; i++) {
                nums[i] = 0;
            }
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]+",");
            }
        }
        // 双指针, 将0 和非零值 以 0 为边界 划分到左右两边, 非零到左 0 到右
        public void moveZeroes2(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]+",");
            }
        }

    }
}
