/**
 * @author： chenr
 * @date： Created on 2020/7/15 10:02
 * @version： v1.0
 * @modified By:
 */
public class ClimbStairs2 {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(4));
        System.out.println(new ClimbStairs().climbStairs2(4));
    }
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        int first = 0;
        int second = 0;
        int step = 1;
        for (int i = 0 ; i < n; i++) {
            first = second;
            second = step;
            step = first + second;
        }
        return step;
    }

    public int climbStairs2(int n) {
        int [] arr = new int[n];
         return helper(arr,n);
    }
    private int helper(int[] arr, int n) {
        arr[0] = 0;
        if (n==1){
            return  1;
        }
        if (n==2) {
           return  2;
        }
      if (arr[n-1] != 0) {
          return arr[n-1];
      }
      arr[n-1] = helper(arr,n-1)+helper(arr,n-2);
      return arr[n-1];
    }

}
