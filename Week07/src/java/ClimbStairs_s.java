/**
 * @author： chenr
 * @date： Created on 2020/7/26 22:08
 * @version： v1.0
 * @modified By:
 */
public class ClimbStairs_s {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs_s().climbStairs1(4));
        System.out.println(new ClimbStairs_s().climbStairs(4));

    }

    public int climbStairs1(int n) {
        if (n <= 0){
            return 0;
        }
        int step1 = 1;
        int step2 = 2;
        if (n == step1) {
            return 1;
        }
        if (n == step2) {
            return 2;
        }
        int result = 0;
        for (int i = 0; i < n-2; i++) {
            result = step1 + step2;
            step1 = step2;
            step2 = result;
        }
        return result;
    }

    public int climbStairs(int n) {
        int[] arr = new int[n];
        return helper(arr, n);
    }

    private int helper(int[] arr, int n) {
        arr[0] = 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (arr[n - 1] != 0) {
            return arr[n - 1];
        }
        arr[n - 1] = helper(arr, n - 1) + helper(arr, n - 2);
        return arr[n - 1];
    }

}
