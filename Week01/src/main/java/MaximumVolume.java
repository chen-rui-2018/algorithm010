/**
 * @author： chenr
 * @date： Created on 2020/6/12 23:13
 * @version： v1.0
 * @modified By:
 * 11. 盛最多水的容器
 */
public class MaximumVolume {
    public static void main(String[] args) {
        int [] height = {1,9,6,2,5,4,8,3,7};
       int max =  maxArea(height);
       int max1 = maxArea1(height);
        System.out.println(max);
        System.out.println("max1:"+max1);
    }

    /**
     * 双指针 夹逼法
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea,Math.min(height[left],height[right])*(right-left));
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    /**
     * 暴力解法 双 for巡检
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {

        int maxArea = 0;
        for (int i = 0; i< height.length - 1; i++) {
            for (int j = i+1; j < height.length; j++) {
                maxArea = Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            }

        }
        return maxArea;
    }
}
