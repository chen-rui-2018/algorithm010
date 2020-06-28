import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeCounterGenerator;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/6/24 16:50
 * @version： v1.0
 * @modified By:
 * 最接近的三数之和
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int [] nums = {-1,2,1,-4};
        int target = 1;
        int aim = new ThreeSumClosest().threeSumClosest(nums,target);
        int aim1 = new ThreeSumClosest().threeSumClosest1(nums,target);
        System.out.println(aim);
        System.out.println(aim1);

    }

    /**
     * 暴力破解 三层循环
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        // 获取三数和
        // 保留差值最小值 和 对应的和 如果相等 则直接返回
        int count = 0;
        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                        int value = nums[i]+nums[j]+nums[k];
                     if ( Math.abs(target-value) < difference) {
                         difference = Math.abs(target-value);
                         count = value;
                         if (count == target) {
                             return count;
                         }
                     }
                }
            }
        }
        return count;
    }
    public int threeSumClosest1(int[] nums, int target) {
        // 先排序
        Arrays.sort(nums);
       int count = Integer.MAX_VALUE;
       // 遍历第一个值
       for (int i = 0; i < nums.length-2; i++) {
           if (i>0 && nums[i] == nums[i-1]) {
                continue;
           }
           int j = i+1;
           int k = nums.length-1;

           while (j<k) {
               int sum = nums[i] + nums[j] +nums[k];
               if (sum == target) {
                   return sum;
               }
               if (Math.abs(count-target)>Math.abs(sum-target)) {
                   count = sum;
               }
               if (sum > target) {
                   k--;
               }else{
                   j++;
               }
           }

       }
        return count;
    }



}
