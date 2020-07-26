/**
 * @author： chenr
 * @date： Created on 2020/7/8 20:22
 * @version： v1.0
 * @modified By:
 * 第 N 个泰波那契数
 */
public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(new Tribonacci().tribonacci(25));
    }
    public int tribonacci(int n) {
        if (n < 3){
            return n==0 ? 0:1;
        }
        int temp = 0, x = 0, y = 1, z = 1;
        for (int i = 3; i <= n; i++) {
            temp = x + y + z;
            x = y;
            y = z;
            z = temp;
        }

       return temp;
    }

    private int helper(int i, int j, int k,int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return helper(i,j,k,n-1);
    }
}
