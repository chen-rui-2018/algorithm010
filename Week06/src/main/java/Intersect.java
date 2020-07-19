import java.util.Arrays;
import java.util.HashMap;

/**
 * @author： chenr
 * @date： Created on 2020/7/13 9:44
 * @version： v1.0
 * @modified By:
 * 两个数组的交集 II
 */
public class Intersect {
    public static void main(String[] args) {
        int [] nums1 = {9,4,9,8,4};
        int [] nums2 = {9,4,9,8,4};
        int [] result = new Intersect().intersect(nums1,nums2);
        int [] result2 = new Intersect().intersect2(nums1,nums2);
        System.out.println();
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return  intersect(nums2,nums1);
        }
        HashMap<Integer,Integer> map = new HashMap<>(16);
        int [] intersectArr = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i],map.get(nums1[i])+1);
            }else {
                map.put(nums1[i],1);
            }
        }
        for (int i = 0; i < nums2.length ; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                intersectArr[index] = nums2[i];
                index++;
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }

        return Arrays.copyOfRange(intersectArr,0,index);
    }
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int j = 0, k = 0;
        int [] intersectArr = new int[Math.min(nums1.length,nums2.length)];
        int index = 0;
       while (j < nums1.length  && k < nums2.length) {
           if (nums1[j] == nums2[k]) {
               intersectArr[index++] = nums1[j];
               j++;
               k++;
           }else if (nums1[j] < nums2[k]) {
               j++;
           } else {
               k++;
           }
       }
        return Arrays.copyOfRange(intersectArr,0,index);
    }
}
