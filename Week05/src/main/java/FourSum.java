import com.sun.org.apache.bcel.internal.classfile.LineNumberTable;

import javax.accessibility.AccessibleHyperlink;
import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2020/7/7 8:43
 * @version： v1.0
 * @modified By:
 */
public class FourSum {
    public static void main(String[] args) {
        int [] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> list =  new FourSum().fourSum(nums,target);
        System.out.println();

    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> hashSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= nums.length-3; j++) {
                int low = j+1;
                int high = nums.length-1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum > target) {
                        high--;
                    }else if (sum < target){
                        low++;
                    }else if (sum == target){

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        if (!hashSet.contains(list)) {
                            hashSet.add(list);
                            result.add(list);
                        }
                        low++;
                        high--;
                    }
                }

            }
        }

        return result;
    }
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> lists =new ArrayList<>();

        for (int i = 0; i < nums.length -3; i++) {
            for (int j = i+1; j < nums.length -2 ; j++) {
                for (int k = j+1; k < nums.length-1 ; k++) {
                    for (int l = k+1; l < nums.length; l++) {
                        if ((nums[i] + nums[j] + nums[k] + nums[l]) == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            lists.add(list);
                        }

                    }
                }
            }
        }
        return lists;
    }
    public List<List<Integer>> fourSum3(int[] nums, int target) {
        List<List<Integer>> result =new ArrayList<>();
        if(nums == null || nums.length <4){
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length -3; i++) {

        }
        return result;
    }

    public List<List<Integer>> fourSum5(int[] nums,int target){
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for(int i=k+1;i<length-2;i++){
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }
        }
        return result;
    }


}
