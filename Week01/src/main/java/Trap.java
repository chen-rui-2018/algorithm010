/**
 * @author： chenr
 * @date： Created on 2020/6/14 23:24
 * @version： v1.0
 * @modified By:
 * 接雨水
 */
public class Trap {
    public static void main(String[] args) {
        Trap  trap = new Trap();
        int [] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        int num =  trap.trap(array);
        System.out.println(num);
    }
    public int trap(int[] height) {

        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
