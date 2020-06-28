/**
 * @author： chenr
 * @date： Created on 2020/6/27 23:27
 * @version： v1.0
 * @modified By:
 * 50. Pow(x, n)
 */
public class MyPow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println( new MyPow().myPow(x,n));
    }

    public double myPow(double x, int n) {
        double result ;
        if ( n < 0) {
            n = -n;
            result =1 / myPowHelper(x,n);
        }else {
            result =  myPowHelper(x,n);
        }
        return result;
    }

    private double myPowHelper(double x, int n) {
        if ( n == 0) {
            return 1.0;
        }
        double result = myPowHelper(x,n/2);

        return  n%2 == 0 ? result*result : result*result*x;
    }

}
