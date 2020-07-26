/**
 * @author： chenr
 * @date： Created on 2020/7/22 9:18
 * @version： v1.0
 * @modified By:
 *  旋转数组的最小数字
 */
public class MinArray {
    public static void main(String[] args) {
        int [] arr = {1};
      int result =    new MinArray().minArray(arr);
        System.out.println(result);
    }
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right) {
         int mid = left + (right - left) / 2;
            if (numbers[right] < numbers[mid]) {
                left = mid+1;
            }else if (numbers[right] > numbers[mid]) {
                right = mid;
            }else {
                right--;
            }

        }
        return numbers[left];
    }
}
