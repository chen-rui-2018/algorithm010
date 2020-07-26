/**
 * @author： chenr
 * @date： Created on 2020/6/20 15:29
 * @version： v1.0
 * @modified By:
 * 爬楼梯
 */
public class ClimbStairs {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        int n = 44;
        System.out.println(new ClimbStairs().climbStairs(n));
        Long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1-startTime);
        System.out.println(new ClimbStairs().climbStairs3(n));
        Long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2-endTime1);

    }
    // 递归超出时间限制
    public int climbStairs(int n) {
        int total = 0;
        if (n==1){
            total = 1;
        }
        if (n==2) {
            total = 2;
        }
        if (n>2) {
            total = climbStairs(n-2)+climbStairs(n-1);
        }
        return total;
    }

    /**
     * 标签：数学
     * 如果观察数学规律，可知本题是斐波那契数列，那么用斐波那契数列的公式即可解决问题，公式如下：
     *
     * F_n = 1/sqrt{5)[((1+sqrt(5))/2)^n - ((1-sqrt(5))/2)^n)]
     *
     * 时间复杂度：O(logn)
     *
     *
     * @param n
     * @return
     */

    public int climbStairs2(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1+sqrt_5)/2,n+1) - Math.pow((1-sqrt_5)/2,n+1);
        return (int)(fib_n/sqrt_5);
    }

    // 动态规划
    public int climbStairs3(int n) {
       int p = 0;
       int q = 0;
       int r = 1;
       for (int i=0; i<n; i++) {
           p = q;
           q = r;
           r = p+q;
       }
       return r;
    }
}
